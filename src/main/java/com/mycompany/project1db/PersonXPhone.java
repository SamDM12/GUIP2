/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class PersonXPhone {
    private int ID_PersonXPhone;
    private int ID_Person;
    private int ID_Phone;

    public PersonXPhone(int ID_PersonXPhone, int ID_Person, int ID_Phone) {
        this.ID_PersonXPhone = ID_PersonXPhone;
        this.ID_Person = ID_Person;
        this.ID_Phone = ID_Phone;
    }

    public int getID_PersonXPhone() {
        return ID_PersonXPhone;
    }

    public void setID_PersonXPhone(int ID_PersonXPhone) {
        this.ID_PersonXPhone = ID_PersonXPhone;
    }

    public int getID_Person() {
        return ID_Person;
    }

    public void setID_Person(int ID_Person) {
        this.ID_Person = ID_Person;
    }

    public int getID_Phone() {
        return ID_Phone;
    }

    public void setID_Phone(int ID_Phone) {
        this.ID_Phone = ID_Phone;
    }
    
    
}
