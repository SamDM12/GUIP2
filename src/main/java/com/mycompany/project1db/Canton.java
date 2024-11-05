/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Canton {
    private int ID_Canton;
    private String Name;
    private int ID_Province;

    public Canton(int ID_Canton, String Name, int ID_Province) {
        this.ID_Canton = ID_Canton;
        this.Name = Name;
        this.ID_Province = ID_Province;
    }

    public int getID_Canton() {
        return ID_Canton;
    }

    public void setID_Canton(int ID_Canton) {
        this.ID_Canton = ID_Canton;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getID_Province() {
        return ID_Province;
    }

    public void setID_Province(int ID_Province) {
        this.ID_Province = ID_Province;
    }
    
    
}
