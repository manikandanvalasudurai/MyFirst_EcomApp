package com.scaler.productservice.services;

import com.scaler.productservice.models.Products;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FakeStoreProductServices implements ProductServices{
    @Override
    public Products getSingleProduct(Long productId) {
        return new Products();
    }

    @Override
    public List<Products> getAllProducts() {
        return List.of();
    }
}
