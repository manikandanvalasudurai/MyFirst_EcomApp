package com.scaler.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Products extends BaseModel {

    private String title;
    private Double price;

    @ManyToOne
    private Category category;

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for price
    public Double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(Double price) {
        this.price = price;
    }

    // Getter for category
    public Category getCategory() {
        return category;
    }

    // Setter for category
    public void setCategory(Category category) {
        this.category = category;
    }
}
