package com.scaler.productservice.dtos;

public class ExceptionDto {
    private String message;
    private String details;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void message(String s) {
    }
}
