package one.pallet.mapper;

import one.pallet.entity.EthBlock;
import one.pallet.utils.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class EthBlockMapper implements RowMapper<EthBlock> {
    //列簇
    private final static byte[] FAMILY = Bytes.toBytes("a");
    //字段
    private final static byte[] COL_LOGSBLOOM = Bytes.toBytes("logsBloom");
    private final static byte[] COL_TOTALDIFFICULTY = Bytes.toBytes("totalDifficulty");
    private final static byte[] COL_RECEIPTSROOT = Bytes.toBytes("receiptsRoot");
    private final static byte[] COL_EXTRADATA = Bytes.toBytes("extraData");
    private final static byte[] COL_NONCE = Bytes.toBytes("nonce");
    private final static byte[] COL_MINER = Bytes.toBytes("miner");
    private final static byte[] COL_DIFFICULTY = Bytes.toBytes("difficulty");
    private final static byte[] COL_GASLIMIT = Bytes.toBytes("gasLimit");
    private final static byte[] COL_NUMBER = Bytes.toBytes("number");
    private final static byte[] COL_GASUSED = Bytes.toBytes("gasUsed");
    private final static byte[] COL_UNCLES = Bytes.toBytes("uncles");
    private final static byte[] COL_SHA3UNCLES = Bytes.toBytes("sha3Uncles");
    private final static byte[] COL_SIZE = Bytes.toBytes("size");
    private final static byte[] COL_TRANSACTIONSROOT = Bytes.toBytes("transactionsRoot");
    private final static byte[] COL_TXCOUNT = Bytes.toBytes("txCount");
    private final static byte[] COL_STATEROOT = Bytes.toBytes("stateRoot");
    private final static byte[] COL_MIXHASH = Bytes.toBytes("mixHash");
    private final static byte[] COL_PARENTHASH = Bytes.toBytes("parentHash");
    private final static byte[] COL_HASH = Bytes.toBytes("hash");
    private final static byte[] COL_TIMESTAMP = Bytes.toBytes("timestamp");
    private final static byte[] COL_TX = Bytes.toBytes("tx");

    @Override
    public EthBlock mapRow(Result result, int rowNum) throws Exception {
        EthBlock dto = new EthBlock();
        //TODO: 设置相关的属性值
        String logsBloom = Bytes.toString(result.getValue(FAMILY, COL_LOGSBLOOM));
        String totalDifficulty = Bytes.toString(result.getValue(FAMILY, COL_TOTALDIFFICULTY));
        String receiptsRoot = Bytes.toString(result.getValue(FAMILY, COL_RECEIPTSROOT));
        String extraData = Bytes.toString(result.getValue(FAMILY, COL_EXTRADATA));
        String nonce = Bytes.toString(result.getValue(FAMILY, COL_NONCE));
        String miner = Bytes.toString(result.getValue(FAMILY, COL_MINER));
        String difficulty = Bytes.toString(result.getValue(FAMILY, COL_DIFFICULTY));
        String gasLimit = Bytes.toString(result.getValue(FAMILY, COL_GASLIMIT));
        String number = Bytes.toString(result.getValue(FAMILY, COL_NUMBER));
        String gasUsed = Bytes.toString(result.getValue(FAMILY, COL_GASUSED));
        String sha3Uncles = Bytes.toString(result.getValue(FAMILY, COL_SHA3UNCLES));
        String size = Bytes.toString(result.getValue(FAMILY, COL_SIZE));
        String transactionsRoot = Bytes.toString(result.getValue(FAMILY, COL_TRANSACTIONSROOT));
        String txCount = Bytes.toString(result.getValue(FAMILY,COL_TXCOUNT));
        String stateRoot = Bytes.toString(result.getValue(FAMILY, COL_STATEROOT));
        String mixHash = Bytes.toString(result.getValue(FAMILY, COL_MIXHASH));
        String parentHash = Bytes.toString(result.getValue(FAMILY, COL_PARENTHASH));
        String hash = Bytes.toString(result.getValue(FAMILY, COL_HASH));
        String timestamp = Bytes.toString(result.getValue(FAMILY, COL_TIMESTAMP));
        String uncles = Bytes.toString(result.getValue(FAMILY, COL_UNCLES));
        String tx = Bytes.toString(result.getValue(FAMILY, COL_TX));
        return dto.setLogsBloom(logsBloom).setTotalDifficulty(totalDifficulty).setReceiptsRoot(receiptsRoot).setExtraData(extraData).
                setNonce(nonce).setMiner(miner).setDifficulty(difficulty).setGasLimit(gasLimit).setNumber(number).setGasUsed(gasUsed).
                setSha3Uncles(sha3Uncles).setSize(size).setTransactionsRoot(transactionsRoot).setTxCount(txCount).setStateRoot(stateRoot).
                setMixHash(mixHash).setParentHash(parentHash).setHash(hash).setTimestamp(timestamp).setUncles(uncles).setTx(tx);
    }
}
