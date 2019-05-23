package one.pallet.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 比特币的交易信息
 */
public class BtcTrans implements Serializable {
    private String hash;
    private int version;
    private int vinsize;
    private int voutsize;
    private long lockTime;
    private long size;
    private String blocktime;
    private String blockHash;
    private String hex;
    private String time;
    private long vsize;
    private String txid;
    private List<BtcVot> vout;
    private List<BtcVin> vin;

    /**
     * 比特币的输入交易
     */
    public static class BtcVin {
        private String coinbase;
        private long sequence;
        private String txid;

        public BtcVin(){
        }

        public String getCoinbase() {
            return coinbase;
        }

        public BtcVin setCoinbase(String coinbase) {
            this.coinbase = coinbase;
            return this;
        }

        public long getSequence() {
            return sequence;
        }

        public BtcVin setSequence(long sequence) {
            this.sequence = sequence;
            return this;
        }

        public String getTxid() {
            return txid;
        }

        public BtcVin setTxid(String txid) {
            this.txid = txid;
            return this;
        }

        @Override
        public String toString() {
            return "BtcVin{" +
                    "coinbase='" + coinbase + '\'' +
                    ", sequence=" + sequence +
                    ", txid='" + txid + '\'' +
                    '}';
        }
    }

    /**
     * 比特币的公钥
     */
    public static class BtcPubkey {
        private String addresses;
        private String asm;
        private String hex;
        private String type;
        private int reqSigs;

        public BtcPubkey(){
        }

        public String getAsm() {
            return asm;
        }

        public BtcPubkey setAsm(String asm) {
            this.asm = asm;
            return this;
        }

        public String getHex() {
            return hex;
        }

        public BtcPubkey setHex(String hex) {
            this.hex = hex;
            return this;
        }

        public int getReqSigs() {
            return reqSigs;
        }

        public BtcPubkey setReqSigs(int reqSigs) {
            this.reqSigs = reqSigs;
            return this;
        }

        public String getType() {
            return type;
        }

        public BtcPubkey setType(String type) {
            this.type = type;
            return this;
        }

        public String getAddresses() {
            return addresses;
        }

        public BtcPubkey setAddresses(String addresses) {
            this.addresses = addresses;
            return this;
        }

        @Override
        public String toString() {
            return "BtcPubkey{" +
                    "addresses=" + addresses +
                    ", asm='" + asm + '\'' +
                    ", hex='" + hex + '\'' +
                    ", type='" + type + '\'' +
                    ", reqSigs='" + reqSigs + '\'' +
                    '}';
        }
    }

    /**
     * 比特币的输出交易
     */
    public static class BtcVot {
        private Double value;
        private int n;
        private BtcPubkey scriptPubKey;

        public BtcVot(){
        }

        public Double getValue() {
            return value;
        }

        public BtcVot setValue(Double value) {
            this.value = value;
            return this;
        }

        public int getN() {
            return n;
        }

        public BtcVot setN(int n) {
            this.n = n;
            return this;
        }

        public BtcPubkey getScriptPubKey() {
            return scriptPubKey;
        }

        public BtcVot setScriptPubKey(BtcPubkey scriptPubKey) {
            this.scriptPubKey = scriptPubKey;
            return this;
        }

        @Override
        public String toString() {
            return "BtcVot{" +
                    "value='" + value + '\'' +
                    ", n='" + n + '\'' +
                    ", scriptPubKey=" + scriptPubKey +
                    '}';
        }
    }

    public BtcTrans(){
    }

    public String getHash() {
        return hash;
    }

    public BtcTrans setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public int getVersion() {
        return version;
    }

    public BtcTrans setVersion(int version) {
        this.version = version;
        return this;
    }

    public int getVinsize() {
        return vinsize;
    }

    public BtcTrans setVinsize(int vinsize) {
        this.vinsize = vinsize;
        return this;
    }

    public int getVoutsize() {
        return voutsize;
    }

    public BtcTrans setVoutsize(int voutsize) {
        this.voutsize = voutsize;
        return this;
    }

    public long getLockTime() {
        return lockTime;
    }

    public BtcTrans setLockTime(long lockTime) {
        this.lockTime = lockTime;
        return this;
    }

    public long getSize() {
        return size;
    }

    public BtcTrans setSize(long size) {
        this.size = size;
        return this;
    }

    public String getBlocktime() {
        return blocktime;
    }

    public BtcTrans setBlocktime(String blocktime) {
        this.blocktime = blocktime;
        return this;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public BtcTrans setBlockHash(String blockHash) {
        this.blockHash = blockHash;
        return this;
    }

    public String getHex() {
        return hex;
    }

    public BtcTrans setHex(String hex) {
        this.hex = hex;
        return this;
    }

    public String getTime() {
        return time;
    }

    public BtcTrans setTime(String time) {
        this.time = time;
        return this;
    }

    public long getVsize() {
        return vsize;
    }

    public BtcTrans setVsize(long vsize) {
        this.vsize = vsize;
        return this;
    }

    public String getTxid() {
        return txid;
    }

    public BtcTrans setTxid(String txid) {
        this.txid = txid;
        return this;
    }

    public List<BtcVot> getVout() {
        return vout;
    }

    public BtcTrans setVout(List<BtcVot> vout) {
        this.vout = vout;
        return this;
    }

    public List<BtcVin> getVin() {
        return vin;
    }

    public BtcTrans setVin(List<BtcVin> vin) {
        this.vin = vin;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BtcTrans that = (BtcTrans) o;
        return Objects.equals(hash, that.hash) ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(hash);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "hash='" + hash + '\'' +
                ", version='" + version + '\'' +
                ", vinsize='" + vinsize + '\'' +
                ", voutsize='" + voutsize + '\'' +
                ", lockTime='" + lockTime + '\'' +
                ", size='" + size + '\'' +
                ", blocktime='" + blocktime + '\'' +
                ", blockHash='" + blockHash + '\'' +
                ", hex='" + hex + '\'' +
                ", time='" + time + '\'' +
                ", vsize='" + vsize + '\'' +
                ", txid='" + txid + '\'' +
                ", vout=" + vout +
                ", vin=" + vin +
                '}';
    }
}




