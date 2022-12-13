package com.company.app.Service;

import com.company.app.model.Stock;
import com.company.app.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public Stock addStock(Stock stock)
    {
       return stockRepository.save(stock);
    }

}
