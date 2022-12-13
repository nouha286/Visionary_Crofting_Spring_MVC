package com.company.app.model;

import com.company.app.Dto.Message;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class CommandItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID ref;
    private Double price;
    private Integer quantity;

    @ManyToOne

    private Command command;
    @ManyToOne
    private Product product;

    @Transient
    private Message message;
}
