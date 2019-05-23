package one.pallet.service;

import one.pallet.entity.BtcTrans;
import one.pallet.mapper.BtcTransMapper;
import one.pallet.utils.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BtcTransService {
    @Autowired
    private HbaseTemplate hbaseTemplate;

    /****************************************(1)查找交易****************************************/
    /**
     * 通过主键查找区块的交易
     * @param rowkey
     * @return
     */
    public BtcTrans getBtcTrans(String rowkey) {
        BtcTrans dto = this.hbaseTemplate.get("btc_trans", rowkey, new BtcTransMapper());
        return dto;
    }

    /**
     * 通过区块号查询所有交易
     * @param strNum 区块编号
     * @return
     */
    public List<BtcTrans> getBtcTransByNum(String strNum) {
        Scan scan = new Scan();
        Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,new RegexStringComparator(".*_" + strNum + "#"));
        scan.setFilter(filter);
        scan.setCaching(50);
        List<BtcTrans> dtos = this.hbaseTemplate.find("btc_trans", scan, new BtcTransMapper());
        return dtos;
    }

    /**
     * 通过交易哈希查询交易
     * @param strHash 交易哈希
     * @return
     */
    public List<BtcTrans> getBtcTransByHash(String strHash) {
        Scan scan = new Scan();
        scan.setFilter(new PrefixFilter(strHash.getBytes()));
        scan.setCaching(1);
        List<BtcTrans> dtos = this.hbaseTemplate.find("btc_trans", scan, new BtcTransMapper());
        return dtos;
    }
}
