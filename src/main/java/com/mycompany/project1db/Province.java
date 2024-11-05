/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Province {
    private int ID_Province;
    private String name;
    private int ID_Country;

    public Province(int ID_Province, String name, int ID_Country) {
        this.ID_Province = ID_Province;
        this.name = name;
        this.ID_Country = ID_Country;
    }

    public int getID_Province() {
        return ID_Province;
    }

    public void setID_Province(int ID_Province) {
        this.ID_Province = ID_Province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID_Country() {
        return ID_Country;
    }

    public void setID_Country(int ID_Country) {
        this.ID_Country = ID_Country;
    }
    
    
}
