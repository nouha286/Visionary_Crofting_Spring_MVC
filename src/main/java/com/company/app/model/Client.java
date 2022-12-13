package com.company.app.model;


import com.company.app.Dto.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;


    @OneToMany(mappedBy = "client")

    private List<Command> commandList;

    @Transient
    private Message message;

    public void setCommandList(Command command)
    {
        this.commandList.add(command);
    }

    public Client() {
    }

    public Client(String name, String email, String password, String phone, String address, List<Command> commandList, Message message) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.commandList = commandList;
        this.message = message;
    }

    public Client(String name, String email, String password, String phone, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", commandList=" + commandList +
                ", message=" + message +
                '}';
    }
}
