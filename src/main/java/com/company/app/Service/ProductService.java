package com.company.app.Service;

import com.company.app.Dto.Message;
import com.company.app.Dto.Pannier;
import com.company.app.Dto.PasserCommande;
import com.company.app.model.Product;
import com.company.app.model.Stock;
import com.company.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Pannier pannier;

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }



    public Product addProduct(Product product)
    {
        Message message=new Message();
        if (product.getCategory()==null||
                 product.getDescription()==null||
                product.getName()==null||
                 product.getQuantity()<0||
                product.getUnitaryPrice()<0)
        {
            message.setMessage("Le produit n'est pas créé , Il faut remplir touts les champs et entrer une quantité et un prix supérieur à 0");
            message.setEtat("L'ajout échoué");
            product.setMessage(message);
            return product;
        }

        message.setMessage("Le produit est créé avec succés ");
        message.setEtat("succés");
        product.setMessage(message);
        product.setProductReference(UUID.randomUUID());
        return productRepository.save(product);
    }



    public Product updateProduct(Product product)
    {
        Message message=new Message();
        Optional<Product> productUpdated=productRepository.findById(product.getId());
        if (!productUpdated.isPresent())
        {
            message.setMessage("Le produit dont l'id"+product.getId()+"n'exist pas ");
            message.setEtat("échoue");
            product.setMessage(message);
            return product;

        }
        if (product.getUnitaryPrice()!=null && product.getUnitaryPrice()>0) productUpdated.get().setUnitaryPrice(product.getUnitaryPrice());
        if(product.getCategory()!=null) productUpdated.get().setCategory(product.getCategory());
        if (product.getQuantity()!=null && product.getQuantity()>0) productUpdated.get().setQuantity(product.getQuantity());
        if(product.getName()!=null) productUpdated.get().setName(product.getName());
        if (product.getDescription()!=null) productUpdated.get().setDescription(product.getDescription());
        message.setMessage("Le produit est modifié avec succés ");
        message.setEtat("succés");
        productUpdated.get().setMessage(message);
        return productRepository.save(productUpdated.get());
    }


    public Message deleteProduct(Long id)
    {
        Message message=new Message();
        Optional<Product> productDeleted=productRepository.findById(id);
        if (productDeleted.isPresent())
        {
            productRepository.delete(productDeleted.get());
            message.setMessage("Le produit est supprimé avec succée");
            message.setEtat("succés");
            return message;
        }

        message.setMessage("Le produit n'est pas supprimé ");
        message.setEtat("échoue");
        return message;

    }


    public Product addNewProductToStock(Product product, Stock stock)
    {
        Message message=new Message();


        if ( product.getCategory()==null ||
                product.getDescription()==null||
                product.getName()==null||
                product.getQuantity()<0||
                product.getUnitaryPrice()<0)
        {
            message.setMessage("Le produit n'est pas créé , Il faut remplir touts les champs et entrer une quantité et un prix supérieur à 0");
            message.setEtat("L'ajout échoué");
            product.setMessage(message);
            return product;
        }
        product.setStockList(stock);
        return productRepository.save(product);

    }


    public Product addExistProductInAStock(Long productId, Stock stock)
    {
        Message message=new Message();
        Optional<Product> product=productRepository.findById(productId);
        if (product.isPresent())
        {
            product.get().setStockList(stock);
            return productRepository.save(product.get());
        }

    Product product1=new Product();
     message.setMessage("L'ajout du stock au produit est échoué");
        message.setEtat("échoue");
        product1.setMessage(message);
        return product1;

    }

    public Optional<Product> findProductByProductReference(UUID ref)
    {
       return productRepository.findProductByProductReference(ref);
    }

    public void getProductFromPannier()
    {
        for (PasserCommande product:
             pannier.getPasserCommandeList()) {
            Optional<Product> product1 =productRepository.findProductByProductReference(product.getRef());
            pannier.setListProduct(product1.get());

        }

    }

}
