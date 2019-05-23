package one.pallet.entity;

import java.io.Serializable;

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

    public BtcBlock setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public BtcBlock setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public String getSize() {
        return size;
    }

    public BtcBlock setSize(String size) {
        this.size = size;
        return this;
    }

    public String getBits() {
        return bits;
    }

    public BtcBlock setBits(String bits) {
        this.bits = bits;
        return this;
    }

    public String getChainwork() {
        return chainwork;
    }

    public BtcBlock setChainwork(String chainwork) {
        this.chainwork = chainwork;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public BtcBlock setHeight(String height) {
        this.height = height;
        return this;
    }

    public String getMerkleroot() {
        return merkleroot;
    }

    public BtcBlock setMerkleroot(String merkleroot) {
        this.merkleroot = merkleroot;
        return this;
    }

    public String getNextHash() {
        return nextHash;
    }

    public BtcBlock setNextHash(String nextHash) {
        this.nextHash = nextHash;
        return this;
    }

    public String getNonce() {
        return nonce;
    }

    public BtcBlock setNonce(String nonce) {
        this.nonce = nonce;
        return this;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public BtcBlock setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
        return this;
    }

    public String getTime() {
        return time;
    }

    public BtcBlock setTime(String time) {
        this.time = time;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public BtcBlock setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getTx() {
        return tx;
    }

    public BtcBlock setTx(String tx) {
        this.tx = tx;
        return this;
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
                '}';
    }
}
