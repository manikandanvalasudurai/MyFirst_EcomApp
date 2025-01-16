package com.scaler.productservice.exceptions;

public class ProductNotFoundException extends Exception {
    private Long productId;
    public ProductNotFoundException(String message) {
        super(message);
        this.productId = productId;
    }
    public Long getProductId() {
        return productId;
    }
}
