/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Phone {
    private int ID_Phone;
    private int Number;
    private int ID_PhoneType;

    public Phone(int ID_Phone, int Number, int ID_PhoneType) {
        this.ID_Phone = ID_Phone;
        this.Number = Number;
        this.ID_PhoneType = ID_PhoneType;
    }

    public int getID_Phone() {
        return ID_Phone;
    }

    public void setID_Phone(int ID_Phone) {
        this.ID_Phone = ID_Phone;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public int getID_PhoneType() {
        return ID_PhoneType;
    }

    public void setID_PhoneType(int ID_PhoneType) {
        this.ID_PhoneType = ID_PhoneType;
    }
    
    
}
