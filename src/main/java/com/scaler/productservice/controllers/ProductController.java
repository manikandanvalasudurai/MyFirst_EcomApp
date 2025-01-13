package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Products;
import com.scaler.productservice.services.ProductServices;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping()
    public List<Products> getAlProducts(){
        return productServices.getAllProducts();
    }

    public void deleteProduct(Long id){

    }
    //PATCH -> Partial update kind of Replace
    @PatchMapping("/{id}")
    public Products updateProduct(@PathVariable("id") Long id, @RequestBody Products product){
        return productServices.updateProduct(id, product);
    }
    @PutMapping("{id}")
    public Products replaceProduct(@PathVariable("id") Long id, @RequestBody Products product){
        return null;
    }

}