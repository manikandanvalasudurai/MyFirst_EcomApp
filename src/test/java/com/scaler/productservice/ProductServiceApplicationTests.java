package com.scaler.productservice;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Products;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {
//	@Autowired
//	private ProductRepository productRepository;
//	@Autowired
//	private CategoryRepository categoryRepository;
//
//	@Test
//	void contextLoads() {
//	}
//	@Test
//	void testDBQueries() {
//		Optional<Products> product = productRepository.findById(1L);
//		Optional<Category> optionalCategory = categoryRepository.findById(1L);
//
//		Category category = optionalCategory.get();
//		System.out.println("Getting Products");
//
//		List<Products> products = category.getProducts();
//		System.out.println("DEBUG");
//
//	}
}
