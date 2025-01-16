package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Products;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductServices implements ProductServices{
    private RestTemplate restTemplate;

    public FakeStoreProductServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Products getSingleProduct(Long productId) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductdto = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
        //Convert FakeStoreProductDto to Products return type since return type is Products+
        if(fakeStoreProductdto == null) {
            throw new ProductNotFoundException("Product with id" + productId +"Doesn' t exists");
        }
        return convertFakeStoreProductDtoToProducts(fakeStoreProductdto);
    }
    @Override
    public List<Products> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject
                ("https://fakestoreapi.com/products",FakeStoreProductDto[].class);

        //convert List of FakeStoreProductDto into List of product
        List<Products> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
             products.add(convertFakeStoreProductDtoToProducts(fakeStoreProductDto));
        }
        if(fakeStoreProductDtos == null){
        }
        return products ;
    }
    //Partial update
    @Override
    public Products updateProduct(Long id, Products product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);

        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class,
                restTemplate.getMessageConverters());

        FakeStoreProductDto response  =  restTemplate.execute("https://fakestoreapi.com/products" + id,
                HttpMethod.PATCH, requestCallback, responseExtractor);

        return convertFakeStoreProductDtoToProducts(response);
    }

    @Override
    public Products replaceProduct(Long id, Products product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

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
