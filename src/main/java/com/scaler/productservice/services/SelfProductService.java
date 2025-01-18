package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Products;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SelfProductService implements ProductServices{
    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Products getSingleProduct(Long productId) throws ProductNotFoundException {
        //Make a call to DB to fetch a product with given Id
        return null;
    }
    @Override
    public List<Products> getAllProducts() {
        return List.of();
    }

    @Override
    public Products updateProduct(Long id, Products product) {
        return null;
    }

    @Override
    public Products replaceProduct(Long id, Products product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
