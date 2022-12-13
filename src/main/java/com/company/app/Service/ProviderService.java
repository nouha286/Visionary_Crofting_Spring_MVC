package com.company.app.Service;

import com.company.app.Dto.Message;
import com.company.app.model.Invoice;
import com.company.app.model.Product;
import com.company.app.model.Provider;
import com.company.app.repository.InvoiceRepository;
import com.company.app.repository.ProductRepository;
import com.company.app.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    ProviderRepository providerRepository;

    InvoiceRepository invoiceRepository;

    ProductRepository productRepository;

    public List<Provider> getProviders()
    {
        return  providerRepository.findAll();
    }

    public void addProvider(Provider provider)
    {
        Optional<Provider> clientOptional=providerRepository.findProviderByEmail(provider.getEmail());
        if (provider.getAddress()==null || provider.getEmail()==null || provider.getPassword()==null ||  provider.getFirstName()==null || provider.getPhone()==null ||  provider.getLastName()==null )
        {
            throw new IllegalStateException("merci de remplir tous les informations du fournisseur  ");
        }

        if (clientOptional.isPresent())
        {
            throw new IllegalStateException("email déja exist");
        }

        providerRepository.save(provider);
    }


    public Message deleteProvider(Long providerId)
    {
        Message message = new Message (  );
        Boolean exists=providerRepository.existsById(providerId);
        if(!exists)
        {
            message.setEtat( "Error" );
            message.setMessage ( "this provider number:"+providerId+" does not exist" );
            return message;
            //throw new IllegalStateException("this provider number:"+providerId+" does not exist");
        } else {
            providerRepository.deleteById(providerId);
            message.setEtat ( "Success" );
            message.setMessage ( "Provider has ben deleted" );
            return message;
        }


    }


    @Transactional
    public Provider updateProvider(Provider provider)
    {
        Message message = new Message (  );
        Provider providerUpdated=providerRepository.findById(provider.getId()).
                orElseThrow(()->new IllegalStateException("this provider number:"+provider.getId()+" does not exist"));

        if (provider.getFirstName()!=null) providerUpdated.setFirstName(provider.getFirstName());
        if (provider.getLastName()!=null) providerUpdated.setLastName(provider.getLastName());
        if (provider.getEmail()!=null) providerUpdated.setEmail(provider.getEmail());
        if (provider.getPassword()!=null) providerUpdated.setPassword(provider.getPassword());
        if (provider.getPhone()!=null) providerUpdated.setPhone(provider.getPhone());
        if (provider.getAddress()!=null) providerUpdated.setAddress(provider.getAddress());


        message.setEtat ( "Success" );
        message.setMessage ( "Provider has ben up to date" );
        provider.setMessage ( message );
        return provider;

    }

    @Transactional
    public Optional<Product> validateInvoice(Long id)
    {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        Optional<Product> productOptional = productRepository.findProductByProductReference(optionalInvoice.get().getRefproduct());

        productOptional.get().setQuantity(productOptional.get().getQuantity()+optionalInvoice.get().getQuantity());

        return productOptional;
    }
}
