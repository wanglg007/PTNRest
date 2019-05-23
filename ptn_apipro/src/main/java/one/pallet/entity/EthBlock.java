package one.pallet.entity;

import java.io.Serializable;

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

    public String getDifficulty() {
        return difficulty;
    }

    public EthBlock setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public String getExtraData() {
        return extraData;
    }

    public EthBlock setExtraData(String extraData) {
        this.extraData = extraData;
        return this;
    }

    public String getGasLimit() {
        return gasLimit;
    }

    public EthBlock setGasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
        return this;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public EthBlock setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public EthBlock setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public String getLogsBloom() {
        return logsBloom;
    }

    public EthBlock setLogsBloom(String logsBloom) {
        this.logsBloom = logsBloom;
        return this;
    }

    public String getMiner() {
        return miner;
    }

    public EthBlock setMiner(String miner) {
        this.miner = miner;
        return this;
    }

    public String getMixHash() {
        return mixHash;
    }

    public EthBlock setMixHash(String mixHash) {
        this.mixHash = mixHash;
        return this;
    }

    public String getNonce() {
        return nonce;
    }

    public EthBlock setNonce(String nonce) {
        this.nonce = nonce;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public EthBlock setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getParentHash() {
        return parentHash;
    }

    public EthBlock setParentHash(String parentHash) {
        this.parentHash = parentHash;
        return this;
    }

    public String getReceiptsRoot() {
        return receiptsRoot;
    }

    public EthBlock setReceiptsRoot(String receiptsRoot) {
        this.receiptsRoot = receiptsRoot;
        return this;
    }

    public String getSha3Uncles() {
        return sha3Uncles;
    }

    public EthBlock setSha3Uncles(String sha3Uncles) {
        this.sha3Uncles = sha3Uncles;
        return this;
    }

    public String getSize() {
        return size;
    }

    public EthBlock setSize(String size) {
        this.size = size;
        return this;
    }

    public String getStateRoot() {
        return stateRoot;
    }

    public EthBlock setStateRoot(String stateRoot) {
        this.stateRoot = stateRoot;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public EthBlock setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getTotalDifficulty() {
        return totalDifficulty;
    }

    public EthBlock setTotalDifficulty(String totalDifficulty) {
        this.totalDifficulty = totalDifficulty;
        return this;
    }

    public String getTransactionsRoot() {
        return transactionsRoot;
    }

    public EthBlock setTransactionsRoot(String transactionsRoot) {
        this.transactionsRoot = transactionsRoot;
        return this;
    }

    public String getUncles() {
        return uncles;
    }

    public EthBlock setUncles(String uncles) {
        this.uncles = uncles;
        return this;
    }

    public String getTxCount() {
        return txCount;
    }

    public EthBlock setTxCount(String txCount) {
        this.txCount = txCount;
        return this;
    }

    public String getTx() {
        return tx;
    }

    public EthBlock setTx(String tx) {
        this.tx = tx;
        return this;
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
