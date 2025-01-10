package com.scaler.productservice;

import com.scaler.productservice.models.Products;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductServiceApplication.class, args);
		Products product = new Products();
		product.setTitle("iphone 15 pro");
	}

}
