package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Products;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductServices{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Products getSingleProduct(Long productId) throws ProductNotFoundException {
        //Make a call to DB to fetch a product with given Id
        Optional<Products> productOptional = productRepository.findById(productId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        return productOptional.get();
    }
    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
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
        productRepository.deleteById(id);
    }

    @Override
    public Products addProduct(Products product) {
        Category category = product.getCategory();
        if(category.getId() == null){
            //we need to create a new category object in the DB first
            category = categoryRepository.save(category);
            product.setCategory(category);
        }
        return productRepository.save(product);
    }
}
