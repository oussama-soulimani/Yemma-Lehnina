package com.YemmaLehnina.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName="product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String name;
    private String picture;
    private String description;
    private float price;
    private boolean available;

    @ElementCollection
    private List<String> ingredients;

    public Product() {
    }

    public Product(Long id, String name, String picture, String description, float price, boolean available, List<String> ingredients) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.price = price;
        this.available = available;
        this.ingredients = ingredients;
    }

    public Product(String name, String picture, String description, float price, boolean available, List<String> ingredients) {
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.price = price;
        this.available = available;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", ingredients=" + ingredients +
                '}';
    }
}
