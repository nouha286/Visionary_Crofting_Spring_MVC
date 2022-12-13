package com.company.app.Dto;

public class Message
{

    private String message;
    private String etat;


    public Message(String message, String etat) {

        this.message = message;
        this.etat = etat;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
