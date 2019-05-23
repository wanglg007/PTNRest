package one.pallet.mapper;

import one.pallet.entity.RegIndx;
import one.pallet.utils.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class RegIndxMapper implements RowMapper<RegIndx> {
    //列簇
    private final static byte[] FAMILY = Bytes.toBytes("a");
    //字段
    private final static byte[] COL_HASH = Bytes.toBytes("hash");

    @Override
    public RegIndx mapRow(Result result, int rowNum) throws Exception {
        RegIndx dto = new RegIndx();
        //TODO: 设置相关的属性值
        String hash = Bytes.toString(result.getValue(FAMILY, COL_HASH));

        return dto.setHash(hash);
    }
}
