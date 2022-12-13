package com.company.app.model;

import com.company.app.Dto.Message;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String LastName;
    private String email;
    private String password;
    private String phone;
    private String address;


    @Transient
    private Message message;
}
