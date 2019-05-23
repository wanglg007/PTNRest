package one.pallet.mapper;

import one.pallet.entity.BtcBlock;
import one.pallet.utils.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class BtcBlockMapper implements RowMapper<BtcBlock> {
    //列簇
    private final static byte[] FAMILY = Bytes.toBytes("a");;
    //字段
    private final static byte[] COL_DIFFICULTY = Bytes.toBytes("difficulty");
    private final static byte[] COL_HASH = Bytes.toBytes("hash");
    private final static byte[] COL_SIZE = Bytes.toBytes("size");
    private final static byte[] COL_BITS = Bytes.toBytes("bits");
    private final static byte[] COL_CHAINWORK = Bytes.toBytes("chainwork");
    private final static byte[] COL_HEIGHT = Bytes.toBytes("height");
    private final static byte[] COL_MRKLROOT = Bytes.toBytes("merkleroot");
    private final static byte[] COL_NEXTHASH= Bytes.toBytes("nextHash");
    private final static byte[] COL_NONCE = Bytes.toBytes("nonce");
    private final static byte[] COL_PREVIOUSHASH = Bytes.toBytes("previousHash");
    private final static byte[] COL_TIME = Bytes.toBytes("time");
    private final static byte[] COL_VERSION = Bytes.toBytes("version");
    private final static byte[] COL_TX = Bytes.toBytes("tx");

    @Override
    public BtcBlock mapRow(Result result, int rowNum) throws Exception {
        BtcBlock dto = new BtcBlock();
        //TODO: 设置相关的属性值
        String difficulty = Bytes.toString(result.getValue(FAMILY, COL_DIFFICULTY));
        String hash = Bytes.toString(result.getValue(FAMILY, COL_HASH));
        String size = Bytes.toString(result.getValue(FAMILY, COL_SIZE));
        String bits = Bytes.toString(result.getValue(FAMILY, COL_BITS));
        String chainwork = Bytes.toString(result.getValue(FAMILY, COL_CHAINWORK));
        String height = Bytes.toString(result.getValue(FAMILY, COL_HEIGHT));
        String merkleroot = Bytes.toString(result.getValue(FAMILY, COL_MRKLROOT));
        String nextHash = Bytes.toString(result.getValue(FAMILY, COL_NEXTHASH));
        String nonce = Bytes.toString(result.getValue(FAMILY, COL_NONCE));
        String previousHash = Bytes.toString(result.getValue(FAMILY, COL_PREVIOUSHASH));
        String time = Bytes.toString(result.getValue(FAMILY, COL_TIME));
        String version = Bytes.toString(result.getValue(FAMILY, COL_VERSION));
        String tx = Bytes.toString(result.getValue(FAMILY, COL_TX));

        return dto.setDifficulty(difficulty).setHash(hash).setSize(size).setBits(bits).setChainwork(chainwork).setHeight(height).
                setMerkleroot(merkleroot).setNextHash(nextHash).setNonce(nonce).setPreviousHash(previousHash).setTime(time).
                setVersion(version).setTx(tx);
    }
}
