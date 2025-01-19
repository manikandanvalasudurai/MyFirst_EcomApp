package com.scaler.productservice.controllers;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Products;
import com.scaler.productservice.services.ProductServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductServices productServices;

    public ProductController(@Qualifier("selfProductService") ProductServices productServices) {
        this.productServices = productServices;
    }

    //https://localhost:8080/products/10
    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductid(@PathVariable("id") Long id) throws ProductNotFoundException {
       // throw new RuntimeException("YOUR DEFINED RUNTIME EXCEPTION");try{
        ResponseEntity<Products> responseEntity = null;
//        try{
//            Products product = productServices.getSingleProduct(id);
//            responseEntity= new ResponseEntity<>(
//                    product, HttpStatus.OK);
//        }
//        catch(RuntimeException e){
//            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        responseEntity = new ResponseEntity<>(
                productServices.getSingleProduct(id),
                HttpStatus.OK
        );
        return responseEntity;
    }
    @GetMapping()
    public List<Products> getAlProducts(){
        return productServices.getAllProducts();
    }
    @DeleteMapping ("/{id}")
    public void deleteProduct(@PathVariable("id") Long ProductId){
        productServices.deleteProduct(ProductId);

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
    @PostMapping()
    public Products addnewProduct(@RequestBody Products product){
        return productServices.addProduct(product);
    }
//
    }
