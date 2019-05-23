package one.pallet.entity;

import java.io.Serializable;

public class RegIndx implements Serializable {
    private String hash;

    public RegIndx(){
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "RegIndx{" +
                "hash='" + hash + '\'' +
                '}';
    }
}
