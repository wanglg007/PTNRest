package one.pallet.service;

import one.pallet.entity.EthTrans;
import one.pallet.mapper.EthTransMapper;
import one.pallet.utils.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EthTransService {
    @Autowired
    private HbaseTemplate hbaseTemplate;

    /****************************************(1)查找交易****************************************/
    /**
     * 通过主键查找区块的交易
     * @param rowkey 主键
     * @return
     */
    public EthTrans getEthTrans(String rowkey) {
        EthTrans dto = this.hbaseTemplate.get("eth_trans", rowkey, new EthTransMapper());
        return dto;
    }

    /**
     * 通过区块号查询所有交易
     * @param strNum 区块编号
     * @return
     */
    public List<EthTrans> getEthTransByNum(String strNum){
        Scan scan = new Scan();
        Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,new RegexStringComparator(".*_" + strNum + "#"));
        scan.setFilter(filter);
        scan.setCaching(200);
        List<EthTrans> dtos = this.hbaseTemplate.find("eth_trans", scan, new EthTransMapper());
        return dtos;
    }

    /**
     * 通过交易哈希查询交易
     * @param strHash 交易哈希
     * @return
     */
    public List<EthTrans> getEthTransByHash(String strHash){
        Scan scan = new Scan();
        scan.setFilter(new PrefixFilter(strHash.getBytes()));
        scan.setCaching(1);
        List<EthTrans> dtos = this.hbaseTemplate.find("eth_trans", scan, new EthTransMapper());
        return dtos;
    }
}
