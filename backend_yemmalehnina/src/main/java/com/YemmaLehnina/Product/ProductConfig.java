package com.YemmaLehnina.Product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            Product Koffie = new Product(
                    "koffie",
                    "koffie.png",
                    null,
                    7,
                    true,
                    List.of("Melk", "Koffie")
            );
            Product Thee = new Product(
                    "thee",
                    "thee.png",
                    null,
                    7,
                    true,
                    List.of("mint", "water", "suiker")
            );
            repository.saveAll(
                    List.of(Thee, Koffie)
            );
        };
    }
}
