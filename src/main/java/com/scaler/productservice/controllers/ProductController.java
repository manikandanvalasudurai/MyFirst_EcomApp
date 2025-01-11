package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Products;
import com.scaler.productservice.services.ProductServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    //https://localhost:8080/products/10
    @GetMapping("/{id}")
    public Products getProductid(@PathVariable("id") Long id){
        return productServices.getSingleProduct(id);
    }

    public List<Products> getAlProducts(){
        return new ArrayList<>();
    }
}