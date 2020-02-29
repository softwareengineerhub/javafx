package com.backend.api.model.version;

import java.io.Serializable;

public class VersionAmountData implements Serializable {

    private static final long serialVersionUID = 7L;
    private int version;
    private int amount;

    public VersionAmountData() {
    }

    public VersionAmountData(int version, int amount) {
        this.version = version;
        this.amount = amount;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
