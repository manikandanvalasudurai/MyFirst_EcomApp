package com.scaler.productservice;

import com.scaler.productservice.models.Products;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);

		// Example usage
		Products product = new Products();
		product.setTitle("iPhone 15 Pro");
		product.setPrice(1299.99);
		System.out.println("Product: " + product.getTitle() + ", Price: $" + product.getPrice());
	}
}
