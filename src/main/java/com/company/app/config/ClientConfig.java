package com.company.app.config;

import com.company.app.model.Client;
import com.company.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {
    @Autowired
    ClientRepository clientRepository;
    @Bean
    CommandLineRunner commandLineRunner1 (ClientRepository clientRepository){
        return args -> {

            Client client=new Client("Mohamed","MOhamed@gmail.com","PASS132","0634483769","YOUSOUFIA");

            clientRepository.save(client);
        };
    }
}
