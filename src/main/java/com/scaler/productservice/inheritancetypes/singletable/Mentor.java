package com.scaler.productservice.inheritancetypes.joinedtables;

public class Mentor extends User {
    private String company;

    public String getCompany() {    return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
