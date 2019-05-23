package one.pallet.service;

import one.pallet.entity.EthBlock;
import one.pallet.mapper.EthBlockMapper;
import one.pallet.utils.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EthBlockService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private HbaseTemplate hbaseTemplate;

    /****************************************(1)查找区块****************************************/
    /**
     * 通过开始区间和结束区间进程查找
     * @param startRow 开始区间
     * @param stopRow  结束区间
     * @return
     */
    public List<EthBlock> getEthBlock(String startRow, String stopRow) {
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(stopRow));
        scan.setCaching(5000);
        List<EthBlock> dtos = this.hbaseTemplate.find("eth_block", scan, new EthBlockMapper());
        return dtos;
    }

    /**
     * 通过主键查找区块
     * @param rowkey 主键
     * @return
     */
    public EthBlock getEthBlock(String rowkey) {
        EthBlock dto = this.hbaseTemplate.get("eth_block", rowkey, new EthBlockMapper());
        return dto;
    }

    /**
     * 通过区块号进行查找
     * @param strNum 区块编号
     * @return
     */
    public List<EthBlock> getEthBlockByHeight(String strNum){
        Scan scan = new Scan();
        Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,new RegexStringComparator(".*_" + strNum + "#"));
        scan.setFilter(filter);
        scan.setCaching(200);
        List<EthBlock> dtos = this.hbaseTemplate.find("eth_block", scan, new EthBlockMapper());
        logger.info("区块编号为：" + strNum + " 返回结果数量为：" + dtos.size());
        return dtos;
    }

    /**
     * 通过区块哈希进行查找，即前缀查询
     * @param strHash 区块哈希
     * @return
     */
    public List<EthBlock> getEthBlockByHash(String strHash) {
        Scan scan = new Scan();
        scan.setFilter(new PrefixFilter(strHash.getBytes()));
        scan.setCaching(2);
        List<EthBlock> dtos = this.hbaseTemplate.find("eth_block", scan, new EthBlockMapper());
        return dtos;
    }

}
