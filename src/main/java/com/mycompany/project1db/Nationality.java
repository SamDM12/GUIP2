/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Nationality {
    private int ID_Nationality;
    private String Name;

    public Nationality(int ID_Nationality, String Name) {
        this.ID_Nationality = ID_Nationality;
        this.Name = Name;
    }

    public int getID_Nationality() {
        return ID_Nationality;
    }

    public void setID_Nationality(int ID_Nationality) {
        this.ID_Nationality = ID_Nationality;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
}
