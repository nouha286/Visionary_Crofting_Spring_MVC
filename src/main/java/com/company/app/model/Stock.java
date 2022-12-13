package com.company.app.model;

import com.company.app.Dto.Message;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    @ManyToMany(fetch = FetchType.EAGER)

    private List<Product> productList;

    @OneToMany(mappedBy = "stock")

    private List<Invoice> invoiceList;
    @Transient
    private Message message;
}
