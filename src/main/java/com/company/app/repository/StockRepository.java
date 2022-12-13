package com.company.app.repository;

import com.company.app.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long>
{
}
