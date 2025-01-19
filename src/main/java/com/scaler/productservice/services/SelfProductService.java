package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Products;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductServices {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    // Constructor to inject repositories
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    // Fetch a single product by ID
    @Override
    public Products getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Products> productOptional = productRepository.findById(productId);

        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found");
        }

        return productOptional.get();
    }

    // Fetch all products
    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    // Update specific fields of an existing product (PATCH operation)
    @Override
    public Products updateProduct(Long id, Products product) throws ProductNotFoundException {
        Optional<Products> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with ID " + id + " doesn't exist");
        }

        Products productInDB = optionalProduct.get();

        if (product.getTitle() != null) {
            productInDB.setTitle(product.getTitle());
        }

        if (product.getPrice() != null) {
            productInDB.setPrice(product.getPrice());
        }

        return productRepository.save(productInDB);
    }
    // Put Method
    // Replace an existing product entirely
    @Override
    public Products replaceProduct(Long id, Products product) throws ProductNotFoundException {
        // Check if the product exists in the database
        Optional<Products> existingProduct = productRepository.findById(id);

        if (existingProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with ID " + id + " not found for PUT method");
        }

        // Replace the existing product with the new product data
        Products productInDB = existingProduct.get();
        if (product.getTitle() == null || product.getPrice() == null || product.getCategory() == null) {
            throw new IllegalArgumentException("Title, price, and category must not be null for replacing a product");
        }

        productInDB.setTitle(product.getTitle());
        productInDB.setPrice(product.getPrice());
        productInDB.setCategory(product.getCategory());

        // Save the updated product to the database
        return productRepository.save(productInDB);
    }


    // Delete a product by ID
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Add a new product to the database
    @Override
    public Products addProduct(Products product) {
        Category category = product.getCategory();

        if (category.getId() == null) {
            // Save the new category in the database
            category = categoryRepository.save(category);
            product.setCategory(category);
        }

        return productRepository.save(product);
    }
}
