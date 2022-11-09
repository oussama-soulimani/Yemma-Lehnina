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
                "Coffee",
                "coffees",
                "koffie.png",
                null,
                7,
                true,
                List.of("Melk", "Koffie")
            );
            Product Koffie2 = new Product(
                "Black Coffee",
                "coffees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Koffie3 = new Product(
                "Espresso",
                "coffees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Koffie4 = new Product(
                "Capuccino",
                "coffees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Koffie5 = new Product(
                "Coffee Cream",
                "coffees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Koffie6 = new Product(
                "Nescafé",
                "coffees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Koffie7 = new Product(
                "Separated coffee",
                "coffees",
                "thee.png",
                null,
                8,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Koffie8 = new Product(
                "Lavazza",
                "coffees",
                "thee.png",
                null,
                12,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Koffie9 = new Product(
                "Lavazza Cream",
                "coffees",
                "thee.png",
                null,
                13,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Koffie10 = new Product(
                "Long Coffee",
                "coffees",
                "thee.png",
                null,
                8,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Koffie11 = new Product(
                "Yemma Lehnina Coffee",
                "coffees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Thee1 = new Product(
                "Mint Tea",
                "thees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Thee2 = new Product(
                "Black Tea",
                "thees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            ); 
            Product Thee3 = new Product(
                "American Tea",
                "thees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Thee4 = new Product(
                "Shiba Tea",
                "thees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product Thee5 = new Product(
                "Herbs Tea",
                "thees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product warm1 = new Product(
                "Warm Milk",
                "coffees",
                "thee.png",
                null,
                6,
                true,
                List.of("mint", "water", "suiker")
            );
            Product warm2 = new Product(
                "Chocolatemilk",
                "coffees",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product cold1 = new Product(
                "Soda",
                "colds",
                "thee.png",
                null,
                8,
                true,
                List.of("mint", "water", "suiker")
            );
            Product cold2 = new Product(
                "Soda Sirop",
                "colds",
                "thee.png",
                null,
                9,
                true,
                List.of("mint", "water", "suiker")
            );
            Product cold3 = new Product(
                "Cold Milk",
                "colds",
                "thee.png",
                null,
                6,
                true,
                List.of("mint", "water", "suiker")
            );
            Product cold4 = new Product(
                "Milk Sirop",
                "colds",
                "thee.png",
                null,
                9,
                true,
                List.of("mint", "water", "suiker")
            );
            Product cold5 = new Product(
                "Energy Drink",
                "colds",
                "thee.png",
                null,
                12,
                true,
                List.of("mint", "water", "suiker")
            );
            Product cold6 = new Product(
                "Red Bull",
                "colds",
                "thee.png",
                null,
                18,
                true,
                List.of("mint", "water", "suiker")
            );
            Product cold7 = new Product(
                "Water Small",
                "colds",
                "thee.png",
                null,
                2,
                true,
                List.of("mint", "water", "suiker")
            );
            Product cold8 = new Product(
                "Water Medium",
                "colds",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product cold9 = new Product(
                "Energy Drink",
                "colds",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product juice1 = new Product(
                "Orange",
                "juices",
                "thee.png",
                null,
                10,
                true,
                List.of("mint", "water", "suiker")
            );
            Product juice2 = new Product(
                "Banana",
                "juices",
                "thee.png",
                null,
                10,
                true,
                List.of("mint", "water", "suiker")
            );
            Product juice3 = new Product(
                "Banana + Apples",
                "juices",
                "thee.png",
                null,
                13,
                true,
                List.of("mint", "water", "suiker")
            );
            Product juice4 = new Product(
                "Banana + Almonds",
                "juices",
                "thee.png",
                null,
                12,
                true,
                List.of("mint", "water", "suiker")
            );
            Product juice5 = new Product(
                "Strawberry",
                "juices",
                "thee.png",
                null,
                12,
                true,
                List.of("mint", "water", "suiker")
            );
            Product juice6 = new Product(
                "Avocado",
                "juices",
                "thee.png",
                null,
                14,
                true,
                List.of("mint", "water", "suiker")
            );
            Product juice7 = new Product(
                "Lemon",
                "juices",
                "thee.png",
                null,
                10,
                true,
                List.of("mint", "water", "suiker")
            );
            Product juice8 = new Product(
                "Milk Panaché",
                "juices",
                "thee.png",
                null,
                15,
                true,
                List.of("mint", "water", "suiker")
            );
            Product juice9 = new Product(
                "Orange Panaché",
                "juices",
                "thee.png",
                null,
                17,
                true,
                List.of("mint", "water", "suiker")
            );
            Product juice10 = new Product(
                "Almond",
                "juices",
                "thee.png",
                null,
                14,
                true,
                List.of("mint", "water", "suiker")
            );
            Product snack1 = new Product(
                "Croque Simple",
                "snacks",
                "thee.png",
                null,
                11,
                true,
                List.of("mint", "water", "suiker")
            );
            Product snack2 = new Product(
                "Croque Cheese",
                "snacks",
                "thee.png",
                null,
                15,
                true,
                List.of("mint", "water", "suiker")
            );
            Product snack3 = new Product(
                "Cake Yemma Lehnina",
                "snacks",
                "thee.png",
                null,
                4,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast1 = new Product(
                "1 Egg Meal",
                "breakfast",
                "thee.png",
                null,
                7,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast2 = new Product(
                "2 Eggs Meal",
                "breakfast",
                "thee.png",
                null,
                10,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast3 = new Product(
                "3 Eggs Meal",
                "breakfast",
                "thee.png",
                null,
                12,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast4 = new Product(
                "1 Egg Beldi Meal",
                "breakfast",
                "thee.png",
                null,
                9,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast5 = new Product(
                "2 Eggs Beldi Meal",
                "breakfast",
                "thee.png",
                null,
                11,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast6 = new Product(
                "Khlie 1 Egg Beldi",
                "breakfast",
                "thee.png",
                null,
                16,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast7 = new Product(
                "Khlie 2 Eggs Beldi",
                "breakfast",
                "thee.png",
                null,
                20,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast8 = new Product(
                "Khlie 2 Eggs Beldi",
                "breakfast",
                "thee.png",
                null,
                20,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast9 = new Product(
                "Cheese Omelette",
                "breakfast",
                "thee.png",
                null,
                15,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast10 = new Product(
                "Cheese Omelette Mortadella",
                "breakfast",
                "thee.png",
                null,
                16,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast11 = new Product(
                "Breakfast Jebli",
                "breakfast",
                "thee.png",
                null,
                23,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast12 = new Product(
                "Breakfast Beldi",
                "breakfast",
                "thee.png",
                null,
                25,
                true,
                List.of("mint", "water", "suiker")
            );
            Product breakfast13 = new Product(
                "Breakfast Dutch",
                "breakfast",
                "thee.png",
                null,
                27,
                true,
                List.of("mint", "water", "suiker")
            );


            

            repository.saveAll(
                List.of(Koffie, Koffie2, Koffie3, Koffie4,Koffie5, Koffie6, Koffie7, Koffie8, Koffie9, Koffie10, Koffie11, warm1,warm2,
                        Thee1, Thee2,Thee3,Thee4,Thee5,
                        cold1,cold2,cold3,cold4,cold5,cold6,cold7,cold8,cold9,
                        snack1,snack2,snack3,
                        breakfast1,breakfast2,breakfast3,breakfast4,breakfast5,breakfast6,breakfast7,breakfast8,breakfast9,breakfast10,breakfast11,breakfast12,breakfast13,
                        juice1,juice2,juice3,juice4,juice5,juice6,juice7,juice8,juice9,juice10
                        )
            );
        };
    }
}
