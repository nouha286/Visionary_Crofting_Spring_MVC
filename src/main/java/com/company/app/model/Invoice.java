package com.company.app.model;

import com.company.app.Dto.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID refproduct;
    private UUID ref;
    @ManyToOne
    private Provider provider;
    @ManyToOne
    private Stock stock;
    private Integer quantity;

    @Transient
    private Message message;

}
