package com.company.app.Service;

import com.company.app.Dto.Message;
import com.company.app.Dto.Pannier;
import com.company.app.Dto.PasserCommande;
import com.company.app.model.Command;
import com.company.app.model.CommandItem;
import com.company.app.model.Product;
import com.company.app.repository.CommandItemRepository;
import com.company.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommandItemService {

    @Autowired
   CommandItemRepository commandItemRepository;
  ProductRepository productRepository;
   ProductService productService;




    public List<CommandItem> getCommandItemList ( )
    {
        return  commandItemRepository.findAll ();
    }

    public CommandItem createCommandItem (UUID ref , Integer quantity, Command command ) {
        Optional<Product> product = productService.findProductByProductReference( ref );
        Message message = new Message (  );

        if (product.get().getQuantity () > 0 &&
                product.get().getQuantity () != null &&
                product.get().getQuantity () >= quantity)
        {
            CommandItem commandItem=new CommandItem();
           commandItem.setRef(UUID.randomUUID());
           commandItem.setPrice(quantity*product.get().getUnitaryPrice());
           commandItem.setQuantity(quantity);
           commandItem.setProduct(product.get());
            commandItem.setCommand ( command );
            commandItemRepository.save ( commandItem );

            product.get().setQuantity ( product.get().getQuantity () - quantity );
            productRepository.save(product.get());
            return commandItem;
        } else {
            CommandItem commandItem1 = new CommandItem (  );
            message.setEtat ( "Infos" );
            message.setMessage ( "Stock over" );
            product.get().setMessage ( message );
            commandItem1.setMessage(message);
            return commandItem1;
        }
    }

    public Message deleteCommandItem ( Long id ) {


        Message message=new Message();
        Optional<CommandItem> CommandItemeleted=commandItemRepository.findById(id);
        if (CommandItemeleted.isPresent())
        {
            commandItemRepository.delete(CommandItemeleted.get());
            message.setMessage("La commande de ce produit est supprimée avec succée");
            message.setEtat("succés");
            return message;
        }

        message.setMessage("La commande de ce produit  n'est pas supprimée ");
        message.setEtat("échoue");
        return message;
    }


}
