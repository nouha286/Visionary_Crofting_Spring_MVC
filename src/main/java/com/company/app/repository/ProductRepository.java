package com.company.app.repository;

import com.company.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository  extends JpaRepository<Product,Long>
{
    Optional<Product> findProductByProductReference(UUID refproduct);

}
