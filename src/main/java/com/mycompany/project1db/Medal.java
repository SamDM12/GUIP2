/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Medal {
    private int ID_Medal;
    private int ID_MedalType;

    public Medal(int ID_Medal, int ID_MedalType) {
        this.ID_Medal = ID_Medal;
        this.ID_MedalType = ID_MedalType;
    }

    public int getID_Medal() {
        return ID_Medal;
    }

    public void setID_Medal(int ID_Medal) {
        this.ID_Medal = ID_Medal;
    }

    public int getID_MedalType() {
        return ID_MedalType;
    }

    public void setID_MedalType(int ID_MedalType) {
        this.ID_MedalType = ID_MedalType;
    }
    
    
}
