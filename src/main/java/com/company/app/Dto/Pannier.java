package com.company.app.Dto;

import com.company.app.model.Command;
import com.company.app.model.CommandItem;
import com.company.app.model.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component

public class Pannier {


    private List<PasserCommande> passerCommandeList = new ArrayList<>();
    private List<Product> product=new ArrayList<>();

    public List<PasserCommande> getPasserCommandeList() {
        return passerCommandeList;
    }

    public void setPasserCommandeList(List<PasserCommande> passerCommandeList) {
        this.passerCommandeList = passerCommandeList;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Pannier() {}

    public void setCommandItemList(PasserCommande passerCommande)
     {
         this.passerCommandeList.add(passerCommande);
     }

     public void setListProduct(Product product)
     {
         this.product.add(product);
     }

    @Override
    public String toString() {
        return "Pannier{" +
                "passerCommandeList=" + passerCommandeList +
                '}';
    }
}
