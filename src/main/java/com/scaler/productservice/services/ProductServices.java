package com.scaler.productservice.services;

import com.scaler.productservice.models.Products;

import java.util.List;

public interface ProductServices {
    Products getSingleProduct(Long productId);
    List<Products> getAllProducts();
    Products updateProduct(Long id,Products product);
    Products replaceProduct(Long id,Products product);
    void deleteProduct(Long id);
}
