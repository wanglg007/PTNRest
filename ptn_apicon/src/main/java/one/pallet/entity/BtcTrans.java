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

        public void setCoinbase(String coinbase) {
            this.coinbase = coinbase;
        }

        public long getSequence() {
            return sequence;
        }

        public void setSequence(long sequence) {
            this.sequence = sequence;
        }

        public String getTxid() {
            return txid;
        }

        public void setTxid(String txid) {
            this.txid = txid;
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

        public void setAsm(String asm) {
            this.asm = asm;
        }

        public String getHex() {
            return hex;
        }

        public void setHex(String hex) {
            this.hex = hex;
        }

        public int getReqSigs() {
            return reqSigs;
        }

        public void setReqSigs(int reqSigs) {
            this.reqSigs = reqSigs;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAddresses() {
            return addresses;
        }

        public void setAddresses(String addresses) {
            this.addresses = addresses;
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

        public void setValue(Double value) {
            this.value = value;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public BtcPubkey getScriptPubKey() {
            return scriptPubKey;
        }

        public void setScriptPubKey(BtcPubkey scriptPubKey) {
            this.scriptPubKey = scriptPubKey;
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

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVinsize() {
        return vinsize;
    }

    public void setVinsize(int vinsize) {
        this.vinsize = vinsize;
    }

    public int getVoutsize() {
        return voutsize;
    }

    public void setVoutsize(int voutsize) {
        this.voutsize = voutsize;
    }

    public long getLockTime() {
        return lockTime;
    }

    public void setLockTime(long lockTime) {
        this.lockTime = lockTime;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getBlocktime() {
        return blocktime;
    }

    public void setBlocktime(String blocktime) {
        this.blocktime = blocktime;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getVsize() {
        return vsize;
    }

    public void setVsize(long vsize) {
        this.vsize = vsize;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public List<BtcVot> getVout() {
        return vout;
    }

    public void setVout(List<BtcVot> vout) {
        this.vout = vout;
    }

    public List<BtcVin> getVin() {
        return vin;
    }

    public void setVin(List<BtcVin> vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BtcTrans btcTrans = (BtcTrans) o;
        return Objects.equals(hash, btcTrans.hash) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash);
    }

    @Override
    public String toString() {
        return "BtcTrans{" +
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




