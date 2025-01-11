package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductServices implements ProductServices{
    private RestTemplate restTemplate;

    public FakeStoreProductServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Products getSingleProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductdto = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
        //Convert FakeStoreProductDto to Products return type since return type is Products
        return convertFakeStoreProductDtoToProducts(fakeStoreProductdto);
    }

    @Override
    public List<Products> getAllProducts() {
        return List.of();
    }

    private Products convertFakeStoreProductDtoToProducts(FakeStoreProductDto fakeStoreProductdto) {
        Products products = new Products();
        products.setId(fakeStoreProductdto.getId());
        products.setTitle(fakeStoreProductdto.getTitle());
        products.setPrice(fakeStoreProductdto.getPrice());
        Category category = new Category();
        category.setDescription(fakeStoreProductdto.getDescription());
        products.setCategory(category);
        return products;
    }
}
