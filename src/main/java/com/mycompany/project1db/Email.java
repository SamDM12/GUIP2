/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Email {
    private int ID_Email;
    private String EmailAdress;
    private int ID_Person;

    public Email(int ID_Email, String EmailAdress, int ID_Person) {
        this.ID_Email = ID_Email;
        this.EmailAdress = EmailAdress;
        this.ID_Person = ID_Person;
    }

    public int getID_Email() {
        return ID_Email;
    }

    public void setID_Email(int ID_Email) {
        this.ID_Email = ID_Email;
    }

    public String getEmailAdress() {
        return EmailAdress;
    }

    public void setEmailAdress(String EmailAdress) {
        this.EmailAdress = EmailAdress;
    }

    public int getID_Person() {
        return ID_Person;
    }

    public void setID_Person(int ID_Person) {
        this.ID_Person = ID_Person;
    }
    
    
}
