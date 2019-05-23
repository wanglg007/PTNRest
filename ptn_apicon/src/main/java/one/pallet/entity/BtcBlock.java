package one.pallet.entity;

import java.io.Serializable;
import java.util.Objects;

public class BtcBlock implements Serializable {
    private String difficulty;
    private String hash;
    private String size;
    private String bits;
    private String chainwork;
    private String height;
    private String merkleroot;
    private String nextHash;
    private String nonce;
    private String previousHash;
    private String time;
    private String version;
    private String tx;

    public BtcBlock(){
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBits() {
        return bits;
    }

    public void setBits(String bits) {
        this.bits = bits;
    }

    public String getChainwork() {
        return chainwork;
    }

    public void setChainwork(String chainwork) {
        this.chainwork = chainwork;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMerkleroot() {
        return merkleroot;
    }

    public void setMerkleroot(String merkleroot) {
        this.merkleroot = merkleroot;
    }

    public String getNextHash() {
        return nextHash;
    }

    public void setNextHash(String nextHash) {
        this.nextHash = nextHash;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTx() {
        return tx;
    }

    public void setTx(String tx) {
        this.tx = tx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BtcBlock btcBlock = (BtcBlock) o;
        return Objects.equals(hash, btcBlock.hash) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash);
    }

    @Override
    public String toString() {
        return "BtcBlock{" +
                "difficulty='" + difficulty + '\'' +
                ", hash='" + hash + '\'' +
                ", size='" + size + '\'' +
                ", bits='" + bits + '\'' +
                ", chainwork='" + chainwork + '\'' +
                ", height='" + height + '\'' +
                ", merkleroot='" + merkleroot + '\'' +
                ", nextHash='" + nextHash + '\'' +
                ", nonce='" + nonce + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", time='" + time + '\'' +
                ", version='" + version + '\'' +
                ", tx='" + tx + '\'' +
                '}';
    }
}
