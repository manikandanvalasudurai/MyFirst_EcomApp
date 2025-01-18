package com.scaler.productservice.inheritancetypes.joinedtables;

public class Student extends User{
    private String batch;

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
