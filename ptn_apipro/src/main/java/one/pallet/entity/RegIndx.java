package one.pallet.entity;

import java.io.Serializable;

/**
 * Index索引库
 */
public class RegIndx implements Serializable {
    private String hash;

    public RegIndx(){
    }

    public String getHash() {
        return hash;
    }

    public RegIndx setHash(String hash) {
        this.hash = hash;
        return this;
    }

    @Override
    public String toString() {
        return "RegIndx{" +
                "hash='" + hash + '\'' +
                '}';
    }
}
