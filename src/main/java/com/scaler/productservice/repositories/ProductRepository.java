package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Products;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    //Product repo should contains all the methods (CRUD) related to Product Model

    List<Products> findByPriceGreaterThanEqual(Double price);
    //Select * from products where price > ?

    Products findProductByTitleLike (String title);  // case sensitive
    //Select * from products where title like = '%word%'

    Products findBytitleLikeIgnoreCase(String title);  // case insensitive
    //Select * from products where title not like ='%word'
    List<Products> findProductsByTitleContainsAndPriceLessThanEqual(String title, Double price);
    Optional<Products> findById(Long id);

    @Override
    List<Products> findAll();
}
