package one.pallet.entity;

import java.io.Serializable;
import java.util.Objects;

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

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EthTrans ethTrans = (EthTrans) o;
        return Objects.equals(hash, ethTrans.hash) ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(hash);
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
