/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class PhoneType {
    private int ID_PhoneType;
    private String Name;

    public PhoneType(int ID_PhoneType, String Name) {
        this.ID_PhoneType = ID_PhoneType;
        this.Name = Name;
    }

    public int getID_PhoneType() {
        return ID_PhoneType;
    }

    public void setID_PhoneType(int ID_PhoneType) {
        this.ID_PhoneType = ID_PhoneType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
}
