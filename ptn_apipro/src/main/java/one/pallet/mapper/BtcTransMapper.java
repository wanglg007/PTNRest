package one.pallet.mapper;

import one.pallet.entity.BtcTrans;
import one.pallet.utils.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.LinkedList;
import java.util.List;

public class BtcTransMapper implements RowMapper<BtcTrans> {
    //列簇
    private final static byte[] FAMILY = Bytes.toBytes("a");
    //字段
    private final static byte[] COL_HASH = Bytes.toBytes("hash");
    private final static byte[] COL_VERSION = Bytes.toBytes("version");
    private final static byte[] COL_VINSIZE = Bytes.toBytes("vinsize");
    private final static byte[] COL_VOUTSIZE = Bytes.toBytes("voutsize");
    private final static byte[] COL_LOCKTIME = Bytes.toBytes("lockTime");
    private final static byte[] COL_SIZE = Bytes.toBytes("size");
    private final static byte[] COL_BLOCKTIME = Bytes.toBytes("blocktime");
    private final static byte[] COL_BLOCKHASH = Bytes.toBytes("blockHash");
    private final static byte[] COL_HEX = Bytes.toBytes("hex");
    private final static byte[] COL_TIME = Bytes.toBytes("time");
    private final static byte[] COL_VSIZE = Bytes.toBytes("vsize");

    @Override
    public BtcTrans mapRow(Result result, int rowNum) throws Exception {
        BtcTrans dto = new BtcTrans();
        List<BtcTrans.BtcVin> inList = new LinkedList<>();
        List<BtcTrans.BtcVot> otList = new LinkedList<>();
        //TODO: 设置相关的属性值
        String hash = Bytes.toString(result.getValue(FAMILY, COL_HASH));
        int version = Bytes.toInt(result.getValue(FAMILY, COL_VERSION));
        int vinsize = Bytes.toInt(result.getValue(FAMILY, COL_VINSIZE));
        int voutsize = Bytes.toInt(result.getValue(FAMILY, COL_VOUTSIZE));
        long lockTime = Bytes.toLong(result.getValue(FAMILY, COL_LOCKTIME));
        long size = Bytes.toLong(result.getValue(FAMILY, COL_SIZE));
        String blocktime = Bytes.toString(result.getValue(FAMILY, COL_BLOCKTIME));
        String blockHash = Bytes.toString(result.getValue(FAMILY, COL_BLOCKHASH));
        String hex = Bytes.toString(result.getValue(FAMILY, COL_HEX));
        String time = Bytes.toString(result.getValue(FAMILY, COL_TIME));
        long vsize = Bytes.toLong(result.getValue(FAMILY, COL_VSIZE));

        //计算交易的输入和输出信息
        int inSize = vinsize;
        int otSize = voutsize;
        //(1.1)计算交易输入
        BtcTrans.BtcVin txIn = null;
        for(int index = 0;index<inSize;index++) {
            txIn = new BtcTrans.BtcVin();
            String coinbase = Bytes.toString(result.getValue(FAMILY, Bytes.toBytes("coinbase_" + index)));
            long sequence = Bytes.toLong(result.getValue(FAMILY, Bytes.toBytes("sequence_" + index)));
            String txid = Bytes.toString(result.getValue(FAMILY, Bytes.toBytes("txid_" + index)));
            txIn.setCoinbase(coinbase).setSequence(sequence).setTxid(txid);
            inList.add(txIn);
        }
        //(1.2)计算交易输出
        BtcTrans.BtcVot txOt = null;
        BtcTrans.BtcPubkey pubkey = null;
        for(int index = 0;index<otSize;index++){
            txOt = new BtcTrans.BtcVot();
            pubkey = new BtcTrans.BtcPubkey();

            Double value = Bytes.toDouble(result.getValue(FAMILY, Bytes.toBytes("value_" + index)));
            int n = Bytes.toInt(result.getValue(FAMILY, Bytes.toBytes("n_" + index)));

            String address = Bytes.toString(result.getValue(FAMILY, Bytes.toBytes("addresses_" + index)));
            String asm = Bytes.toString(result.getValue(FAMILY, Bytes.toBytes("asm_" + index)));
            String strhex = Bytes.toString(result.getValue(FAMILY, Bytes.toBytes("hex_" + index)));
            String type = Bytes.toString(result.getValue(FAMILY, Bytes.toBytes("type_" + index)));
            int reqsigs = Bytes.toInt(result.getValue(FAMILY, Bytes.toBytes("reqSigs_" + index)));
            pubkey.setAddresses(address).setAsm(asm).setHex(strhex).setType(type).setReqSigs(reqsigs);

            txOt.setN(n).setScriptPubKey(pubkey).setValue(value);
            otList.add(txOt);
        }

        return dto.setHash(hash).setVersion(version).setVinsize(vinsize).setVoutsize(voutsize).setLockTime(lockTime).setSize(size).
                setBlocktime(blocktime).setBlockHash(blockHash).setHex(hex).setTime(time).setVsize(vsize).
                setVout(otList).setVin(inList);
    }
}
