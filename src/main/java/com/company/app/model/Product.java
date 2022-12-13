package com.company.app.model;

import com.company.app.Dto.Message;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private UUID productReference;
    private String name;
    private Double unitaryPrice;
    private String description;
    private String category;
    private Integer quantity;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})

    private List<Stock> stockList ;

    @OneToMany(mappedBy = "product")
    private List<CommandItem> commandItemList ;


    @Transient
    private Message message;

    public void setStockList ( Stock stock ) {
        this.stockList.add ( stock );
    }

    public Product() {
    }

    public Product(String name, Double unitaryPrice, String description, String category, Integer quantity) {
        this.name = name;
        this.unitaryPrice = unitaryPrice;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
    }
}
