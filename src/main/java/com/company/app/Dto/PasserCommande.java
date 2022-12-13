package com.company.app.Dto;

import java.util.UUID;

public class PasserCommande {
    private UUID ref;
    private Integer quantity;
    public PasserCommande() {}
    public PasserCommande(UUID ref, Integer quantity) {
        this.ref = ref;
        this.quantity = quantity;
    }

    public UUID getRef() {
        return ref;
    }
    public void setRef(UUID ref) {
        this.ref = ref;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PasserCommande{" +
                "ref='" + ref + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
