package com.scaler.productservice.services;

import com.scaler.productservice.models.Products;

import java.util.List;

public interface ProductServices {
    Products getSingleProduct(Long productId);
    List<Products> getAllProducts();
}
