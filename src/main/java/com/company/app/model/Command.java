package com.company.app.model;

import com.company.app.Dto.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID ref;

    private String dateTime;
    private Double totalPrice ;
    private String address;

    @ManyToOne

    private Client client;
    @OneToMany(mappedBy = "command")

    private List<CommandItem> listItem = new ArrayList<>();

    @Transient
    private Message message;

    public void setItem(CommandItem commandItem)
    {
        this.listItem.add(commandItem);
    }
}
