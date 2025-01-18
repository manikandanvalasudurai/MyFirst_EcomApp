package com.scaler.productservice.inheritancetypes.joinedtables;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "jt_instructors")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User{
    private String Subject;

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
