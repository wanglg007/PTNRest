package one.pallet.service;

import one.pallet.entity.RegIndx;
import one.pallet.mapper.RegIndxMapper;
import one.pallet.utils.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegIndxService {
    @Autowired
    private HbaseTemplate hbaseTemplate;

    /****************************************(1)查找索引****************************************/
    /**
     * 通过发送/接收地址进行交易查询
     * @param strTable   表格
     * @param isSend     是否发送地址
     * @param strAddress 地址
     * @return
     */
    public List<RegIndx> getRegIndxByAddress(String strTable, boolean isSend, String strAddress) {
        String strPrefix = strAddress + (isSend ? "_F_" : "_T_");       //若isSend为true，则为发送地址
        Scan scan = new Scan();
        scan.setFilter(new PrefixFilter(strPrefix.getBytes()));
        scan.setCaching(100);
        List<RegIndx> dtos = this.hbaseTemplate.find(strTable, scan, new RegIndxMapper());
        return dtos;
    }

    /**
     * 通过主键进行交易查询
     * @param strTable 表格
     * @param strKey   主键
     * @return
     */
    public RegIndx getRegIndxByKey(String strTable,String strKey) {
        RegIndx dto = this.hbaseTemplate.get(strTable, strKey, new RegIndxMapper());
        return dto;
    }
}
