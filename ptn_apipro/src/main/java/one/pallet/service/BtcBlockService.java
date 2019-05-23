package one.pallet.service;

import one.pallet.entity.BtcBlock;
import one.pallet.mapper.BtcBlockMapper;
import one.pallet.utils.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BtcBlockService {
    @Autowired
    private HbaseTemplate hbaseTemplate;

    /****************************************(1)查找区块****************************************/
    /**
     * 通过开始区间和结束区间进程查找
     * @param startRow 开始区间
     * @param stopRow  结束区间
     * @return
     */
    public List<BtcBlock> getBtcBlock(String startRow, String stopRow) {
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(stopRow));
        scan.setCaching(5000);
        List<BtcBlock> dtos = this.hbaseTemplate.find("btc_block", scan, new BtcBlockMapper());
        return dtos;
    }

    /**
     * 通过主键查找区块
     * @param rowkey 主键
     * @return
     */
    public BtcBlock getBtcBlock(String rowkey) {
        BtcBlock dto = this.hbaseTemplate.get("btc_block", rowkey, new BtcBlockMapper());
        return dto;
    }

    /**
     * 通过区块号进程查找
     * @param strNum 区块编号
     * @return
     */
    public List<BtcBlock> getBtcBlockByNum(String strNum){
        Scan scan = new Scan();
        Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,new RegexStringComparator(".*_" + strNum + "#"));
        scan.setFilter(filter);
        scan.setCaching(10);
        List<BtcBlock> dtos = this.hbaseTemplate.find("btc_block", scan, new BtcBlockMapper());
        return dtos;
    }

    /**
     * 通过区块哈希进行查找，即前缀查询
     * @param strHash 区块哈希
     * @return
     */
    public List<BtcBlock> getBtcBlockByHash(String strHash){
        Scan scan = new Scan();
        scan.setFilter(new PrefixFilter(strHash.getBytes()));
        scan.setCaching(10);
        List<BtcBlock> dtos = this.hbaseTemplate.find("btc_block", scan, new BtcBlockMapper());
        return dtos;
    }

}
