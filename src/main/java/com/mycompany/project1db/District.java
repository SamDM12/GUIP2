/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class District {
    private int ID_District;
    private String Name;
    private int ID_Canton;

    public District(int ID_District, String Name, int ID_Canton) {
        this.ID_District = ID_District;
        this.Name = Name;
        this.ID_Canton = ID_Canton;
    }

    public int getID_District() {
        return ID_District;
    }

    public void setID_District(int ID_District) {
        this.ID_District = ID_District;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getID_Canton() {
        return ID_Canton;
    }

    public void setID_Canton(int ID_Canton) {
        this.ID_Canton = ID_Canton;
    }
    
    
}
