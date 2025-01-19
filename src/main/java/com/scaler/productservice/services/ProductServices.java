package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Products;

import java.util.List;

public interface ProductServices {
    Products getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Products> getAllProducts();
    Products updateProduct(Long id,Products product) throws ProductNotFoundException;
    Products replaceProduct(Long id,Products product) throws ProductNotFoundException;
    void deleteProduct(Long id);
    public Products addProduct(Products product);
}
