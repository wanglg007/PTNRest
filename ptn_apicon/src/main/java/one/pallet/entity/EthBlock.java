package one.pallet.entity;

import java.io.Serializable;
import java.util.Objects;

public class EthBlock implements Serializable {
    private String logsBloom;
    private String totalDifficulty;
    private String receiptsRoot;
    private String extraData;
    private String nonce;
    private String miner;
    private String difficulty;
    private String gasLimit;
    private String number;
    private String gasUsed;
    private String sha3Uncles;
    private String size;
    private String transactionsRoot;
    private String txCount;
    private String stateRoot;
    private String mixHash;
    private String parentHash;
    private String hash;
    private String timestamp;
    private String uncles;
    private String tx;

    public EthBlock(){
    }

    public String getLogsBloom() {
        return logsBloom;
    }

    public void setLogsBloom(String logsBloom) {
        this.logsBloom = logsBloom;
    }

    public String getTotalDifficulty() {
        return totalDifficulty;
    }

    public void setTotalDifficulty(String totalDifficulty) {
        this.totalDifficulty = totalDifficulty;
    }

    public String getReceiptsRoot() {
        return receiptsRoot;
    }

    public void setReceiptsRoot(String receiptsRoot) {
        this.receiptsRoot = receiptsRoot;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getSha3Uncles() {
        return sha3Uncles;
    }

    public void setSha3Uncles(String sha3Uncles) {
        this.sha3Uncles = sha3Uncles;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTransactionsRoot() {
        return transactionsRoot;
    }

    public void setTransactionsRoot(String transactionsRoot) {
        this.transactionsRoot = transactionsRoot;
    }

    public String getTxCount() {
        return txCount;
    }

    public void setTxCount(String txCount) {
        this.txCount = txCount;
    }

    public String getStateRoot() {
        return stateRoot;
    }

    public void setStateRoot(String stateRoot) {
        this.stateRoot = stateRoot;
    }

    public String getMixHash() {
        return mixHash;
    }

    public void setMixHash(String mixHash) {
        this.mixHash = mixHash;
    }

    public String getParentHash() {
        return parentHash;
    }

    public void setParentHash(String parentHash) {
        this.parentHash = parentHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUncles() {
        return uncles;
    }

    public void setUncles(String uncles) {
        this.uncles = uncles;
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
        EthBlock ethBlock = (EthBlock) o;
        return Objects.equals(hash, ethBlock.hash) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash);
    }

    @Override
    public String toString() {
        return "EthBlock{" +
                "logsBloom='" + logsBloom + '\'' +
                ", totalDifficulty='" + totalDifficulty + '\'' +
                ", receiptsRoot='" + receiptsRoot + '\'' +
                ", extraData='" + extraData + '\'' +
                ", nonce='" + nonce + '\'' +
                ", miner='" + miner + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", gasLimit='" + gasLimit + '\'' +
                ", number='" + number + '\'' +
                ", gasUsed='" + gasUsed + '\'' +
                ", sha3Uncles='" + sha3Uncles + '\'' +
                ", size='" + size + '\'' +
                ", transactionsRoot='" + transactionsRoot + '\'' +
                ", txCount='" + txCount + '\'' +
                ", stateRoot='" + stateRoot + '\'' +
                ", mixHash='" + mixHash + '\'' +
                ", parentHash='" + parentHash + '\'' +
                ", hash='" + hash + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", uncles='" + uncles + '\'' +
                ", tx='" + tx + '\'' +
                '}';
    }
}
