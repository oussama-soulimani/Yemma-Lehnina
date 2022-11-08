package com.YemmaLehnina.Product;

// API Layer

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/products/{category}")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(@PathVariable("category") String category){
        return productService.getProducts(category);
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false)  String name,
            @RequestParam(required = false)  String category,
            @RequestParam(required = false)  String picture,
            @RequestParam(required = false)  String description,
            @RequestParam(required = true)  float price,
            @RequestParam(required = false)  boolean available,
            @RequestParam(required = false)  List<String> ingredients){
        productService.updateProduct(productId, name, picture, description, price, available, ingredients);
    }
}
