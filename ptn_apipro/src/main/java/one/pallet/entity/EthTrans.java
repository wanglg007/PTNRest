package one.pallet.entity;

import java.io.Serializable;

public class EthTrans implements Serializable {
    private String blockHash;
    private String transactionIndex;
    private String nonce;
    private String input;
    private String r;
    private String s;
    private String v;
    private String blockNumber;
    private String gas;
    private String from;
    private String to;
    private String value;
    private String hash;
    private String gasPrice;

    public EthTrans(){
    }

    public String getBlockHash() {
        return blockHash;
    }

    public EthTrans setBlockHash(String blockHash) {
        this.blockHash = blockHash;
        return this;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public EthTrans setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public EthTrans setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getGas() {
        return gas;
    }

    public EthTrans setGas(String gas) {
        this.gas = gas;
        return this;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public EthTrans setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public EthTrans setHash(String txhash) {
        this.hash = txhash;
        return this;
    }

    public String getInput() {
        return input;
    }

    public EthTrans setInput(String input) {
        this.input = input;
        return this;
    }

    public String getNonce() {
        return nonce;
    }

    public EthTrans setNonce(String nonce) {
        this.nonce = nonce;
        return this;
    }

    public String getR() {
        return r;
    }

    public EthTrans setR(String r) {
        this.r = r;
        return this;
    }

    public String getS() {
        return s;
    }

    public EthTrans setS(String s) {
        this.s = s;
        return this;
    }

    public String getTo() {
        return to;
    }

    public EthTrans setTo(String to) {
        this.to = to;
        return this;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public EthTrans setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
        return this;
    }

    public String getV() {
        return v;
    }

    public EthTrans setV(String v) {
        this.v = v;
        return this;
    }

    public String getValue() {
        return value;
    }

    public EthTrans setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "EthTrans{" +
                "blockHash='" + blockHash + '\'' +
                ", transactionIndex='" + transactionIndex + '\'' +
                ", nonce='" + nonce + '\'' +
                ", input='" + input + '\'' +
                ", r='" + r + '\'' +
                ", s='" + s + '\'' +
                ", v='" + v + '\'' +
                ", blockNumber='" + blockNumber + '\'' +
                ", gas='" + gas + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", value='" + value + '\'' +
                ", hash='" + hash + '\'' +
                ", gasPrice='" + gasPrice + '\'' +
                '}';
    }
}
