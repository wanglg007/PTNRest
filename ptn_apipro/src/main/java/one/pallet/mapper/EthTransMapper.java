package one.pallet.mapper;

import one.pallet.entity.EthTrans;
import one.pallet.utils.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class EthTransMapper implements RowMapper<EthTrans> {
    //列簇
    private final static byte[] FAMILY = Bytes.toBytes("a");
    //字段
    private final static byte[] COL_BLOCKHASH = Bytes.toBytes("blockHash");
    private final static byte[] COL_TRANSACTIONINDEX = Bytes.toBytes("transactionIndex");
    private final static byte[] COL_NONCE = Bytes.toBytes("nonce");
    private final static byte[] COL_INPUT = Bytes.toBytes("input");
    private final static byte[] COL_R = Bytes.toBytes("r");
    private final static byte[] COL_S = Bytes.toBytes("s");
    private final static byte[] COL_V = Bytes.toBytes("v");
    private final static byte[] COL_BLOCKNUMBER = Bytes.toBytes("blockNumber");
    private final static byte[] COL_GAS = Bytes.toBytes("gas");
    private final static byte[] COL_FROM = Bytes.toBytes("from");
    private final static byte[] COL_TO = Bytes.toBytes("to");
    private final static byte[] COL_VALUE = Bytes.toBytes("value");
    private final static byte[] COL_HASH = Bytes.toBytes("hash");
    private final static byte[] COL_GASPRICE = Bytes.toBytes("gasPrice");

    @Override
    public EthTrans mapRow(Result result, int rowNum) throws Exception {
        EthTrans dto = new EthTrans();
        //TODO: 设置相关的属性值
        String blockHash = Bytes.toString(result.getValue(FAMILY, COL_BLOCKHASH));
        String transactionIndex = Bytes.toString(result.getValue(FAMILY, COL_TRANSACTIONINDEX));
        String nonce = Bytes.toString(result.getValue(FAMILY, COL_NONCE));
        String input = Bytes.toString(result.getValue(FAMILY, COL_INPUT));
        String r = Bytes.toString(result.getValue(FAMILY, COL_R));
        String s = Bytes.toString(result.getValue(FAMILY, COL_S));
        String v = Bytes.toString(result.getValue(FAMILY, COL_V));
        String blockNumber = Bytes.toString(result.getValue(FAMILY, COL_BLOCKNUMBER));
        String gas = Bytes.toString(result.getValue(FAMILY, COL_GAS));
        String from = Bytes.toString(result.getValue(FAMILY, COL_FROM));
        String to = Bytes.toString(result.getValue(FAMILY, COL_TO));
        String value = Bytes.toString(result.getValue(FAMILY, COL_VALUE));
        String hash = Bytes.toString(result.getValue(FAMILY, COL_HASH));
        String gasPrice = Bytes.toString(result.getValue(FAMILY, COL_GASPRICE));

        return dto.setBlockHash(blockHash).setTransactionIndex(transactionIndex).setNonce(nonce).setInput(input).setR(r).setS(s).
                setV(v).setBlockNumber(blockNumber).setGas(gas).setFrom(from).setTo(to).setValue(value).setHash(hash).
                setGasPrice(gasPrice);
    }
}
