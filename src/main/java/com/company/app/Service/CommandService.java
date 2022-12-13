package com.company.app.Service;

import com.company.app.Dto.Message;
import com.company.app.Dto.PasserCommande;
import com.company.app.model.Client;
import com.company.app.model.Command;
import com.company.app.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class CommandService {

    @Autowired
    CommandRepository commandRepository;
    CommandItemService commandItemService;


    public List<Command> getAllCommands()
    {
       return commandRepository.findAll();
    }


    public Command addCommand(Command command)
    {
        Message message=new Message();

        if (command.getAddress()==null||
        command.getDateTime()==null)
        {
            message.setMessage("il faut remplir tout les champs");
            message.setEtat("échoue");
            command.setMessage(message);
            return command;
        }

        message.setMessage("la commande est ajouté avec succée");
        message.setEtat("succés");
        command.setMessage(message);
        command.setRef(UUID.randomUUID());
        return commandRepository.save(command);
    }


    public Command updateCommand(Command command)
    {
        Message message=new Message();
        Optional<Command> commandUpdate=commandRepository.findById(command.getId());
        if (commandUpdate.isPresent())
        {
            if (command.getAddress()!=null) commandUpdate.get().setAddress(command.getAddress());
            if (command.getDateTime()!=null) commandUpdate.get().setDateTime(command.getDateTime());
            message.setMessage("la commande est modifié avec succés");
            message.setEtat("succés");
            commandUpdate.get().setMessage(message);
            return commandRepository.save(commandUpdate.get());
        }
        message.setMessage("la commande à modifier n'exist pas");
        message.setEtat("échoue");
        command.setMessage(message);

        return command;
    }


    public Message deleteCommand(Long id)
    {
        Message message=new Message();

        Optional<Command> commandDeleted=commandRepository.findById(id);
        if (commandDeleted.isPresent())
        {
            commandRepository.delete(commandDeleted.get());
            message.setMessage("La commande est supprimée avec succés ");
            message.setEtat("succés");
            return message;

        }
        message.setMessage("La commande n'est pas supprimée, une erreur c'est produite !");
        message.setEtat("échoue");
        return message;
    }


    public Command createCommandForAclient(Collection<PasserCommande> productList , Client client) {
        Command command = new Command();

        command.setAddress(client.getAddress());

        command.setRef(UUID.randomUUID());
        command.setDateTime(LocalDate.now().toString());
        command.setClient ( client );
        // fr
        addCommand( command );
        productList.stream().forEach((product) -> {
            command.setItem(commandItemService.createCommandItem(product.getRef(), product.getQuantity(), command));

        });
        command.setTotalPrice(0.0);
        command.getListItem().stream().forEach((item) -> {
            command.setTotalPrice( command.getTotalPrice () + item.getPrice ());
            System.out.println(item.getPrice());
        });


        commandRepository.save (command);
        return command;
    }


}
