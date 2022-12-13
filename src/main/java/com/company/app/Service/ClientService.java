package com.company.app.Service;


import com.company.app.Dto.Message;
import com.company.app.Dto.Pannier;
import com.company.app.Dto.PasserCommande;
import com.company.app.model.Client;
import com.company.app.model.Command;
import com.company.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    CommandService commandService;


    public List<Client> getAllClients()
    {
        return clientRepository.findAll();
    }



    public Client addClient(Client client)
    {
        Message message=new Message();
        if (client.getAddress()==null||
                client.getEmail()==null||
                client.getName()==null ||
                client.getPassword()==null ||
                client.getPhone()==null )
        {
            message.setMessage("Le compte client n'est pas créé , Il faut remplir touts les champs ");
            message.setEtat("L'ajout échoué");
            client.setMessage(message);
            return client;
        }

      Optional<Client> clientOptional=clientRepository.findClientByEmail(client.getEmail());

        if (clientOptional!=null)
        {
            message.setMessage("Cet email est déja exist , merci d'essayer avec un autre email ");
            message.setEtat("L'ajout échoué");
            client.setMessage(message);
            return client;
        }

        message.setMessage("Le compte est ajouté avec succés ");
        message.setEtat("succés");
        client.setMessage(message);


        return clientRepository.save(client);
    }


    public Client updateClient(Client client)
    {
        Optional<Client> clientOptional=clientRepository.findById(client.getId());
        Message message=new Message();

        if (!clientOptional.isPresent())
        {
            message.setMessage("Le compte que vous voulez modifier n'éxiste pas");
            message.setEtat("échoue");
            client.setMessage(message);
            return client;

        }


        if(client.getName()!=null) clientOptional.get().setName(client.getName());
        if (client.getEmail()!=null)clientOptional.get().setEmail(client.getEmail());
        if (client.getPassword()!=null)  clientOptional.get().setPassword(client.getPassword());
        if (client.getPassword()!=null) clientOptional.get().setPhone(client.getPhone());
        if (client.getAddress()!=null) clientOptional.get().setAddress(client.getAddress());
        message.setMessage("Le compte est modifié avec succés ");
        message.setEtat("succés");
        clientOptional.get().setMessage(message);

        return clientRepository.save(clientOptional.get());
    }



    public Message deleteClient(Long id)
    {
        Message message=new Message();
        Optional<Client> clientOptional=clientRepository.findById(id);
        if (clientOptional.isPresent())
        {
           clientRepository.delete(clientOptional.get());
            message.setMessage("Le compte est supprimé avec succés ");
            message.setEtat("succés");
            return message;

        }
        message.setMessage("Le compte n'est pas supprimé, une erreur c'est produite !");
        message.setEtat("échoue");
        return message;

    }

    public Client addCommandForClient(Long id, Command command)
    {
        Optional<Client> clientOptional=clientRepository.findById(id);
        clientOptional.get().setCommandList(command);
        return clientRepository.save(clientOptional.get());
    }

    public Client passerCommande(Long id, Collection<PasserCommande> productList)
    {
      Optional<Client> clientOptional=clientRepository.findById(id);
      if (clientOptional.isPresent())
      {
          Command command=commandService.createCommandForAclient(productList,clientOptional.get());
          return addCommandForClient(id,command);
      }
      Message message=new Message();
        Client client=new Client();
      message.setMessage("le client qui a passé la commande n'existe pas");
      message.setEtat("échoue");
        client.setMessage(message);
      return client;
    }


    public Optional<Client>  findClientByEmail(String email)
    {
        return clientRepository.findClientByEmail(email);
    }

    public String login(String email, String password)
    {
       Optional<Client>  client= clientRepository.findClientByEmail(email);
        if( client.get().getPassword()==password && client.get().getEmail()==email)
        {
          return "true";
        }
        else
        {
            return "false";
        }

    }






}
