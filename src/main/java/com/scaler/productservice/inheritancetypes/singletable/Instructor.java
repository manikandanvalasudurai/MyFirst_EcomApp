package com.scaler.productservice.inheritancetypes.joinedtables;

public class Instructor extends User{
    private String Subject;

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
