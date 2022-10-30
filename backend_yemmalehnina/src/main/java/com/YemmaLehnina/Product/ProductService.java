package com.YemmaLehnina.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        Optional<Product> productByName = productRepository.findProductByName(product.getName());
        if(productByName.isPresent()){
            throw new IllegalStateException("Product already existing!");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("Product with id "+productId+" does not exist!");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, String name, String picture, String description, float price, boolean available, List<String> ingredients) {
        Product product =productRepository.findById(productId).orElseThrow(()-> new IllegalStateException(
                "product with id "+productId+" does not exist"));

        System.out.println("Update");
        if(name !=null && name.length()>0 && !Objects.equals(product.getName(), name)){
            Optional<Product> productOptional = productRepository.findProductByName(name);
            if(productOptional.isPresent()){
                throw new IllegalStateException("Product with name "+name+" already exists");
            }
            product.setName(name);
        }
        if(picture !=null && picture.length()>0 && !Objects.equals(product.getPicture(), picture)){
            product.setPicture(picture);
        }
        if(description !=null && description.length()>0 && !Objects.equals(product.getDescription(), description)){
            product.setDescription(description);
        }
        if(price !=0 && !Objects.equals(product.getPrice(), price)){
            product.setPrice(price);
        }
        if(!Objects.equals(product.isAvailable(), available)){
            product.setAvailable(available);
        }
        if(!Objects.equals(product.getIngredients(), ingredients)){
            product.setIngredients(ingredients);
        }

    }
}
