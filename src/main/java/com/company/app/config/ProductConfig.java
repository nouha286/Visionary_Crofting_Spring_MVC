package com.company.app.config;

import com.company.app.model.Product;
import com.company.app.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner3(ProductRepository productRepository) {
        return args -> {
            Product product1 = new Product("r1", 14.00, "h", "d1", 15);
            product1.setProductReference(UUID.randomUUID());
            Product product2 = new Product("r1", 20.8, "h", "d1", 15);
            Product product3 = new Product("r1", 99.99, "h", "d1", 15);
            productRepository.saveAll(List.of(product1, product2, product3));

        };
    }
}
