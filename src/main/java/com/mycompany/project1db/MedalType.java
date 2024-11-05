/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class MedalType {
    private int ID_MedalType;
    private String TypeName;

    public MedalType(int ID_MedalType, String TypeName) {
        this.ID_MedalType = ID_MedalType;
        this.TypeName = TypeName;
    }

    public int getID_MedalType() {
        return ID_MedalType;
    }

    public void setID_MedalType(int ID_MedalType) {
        this.ID_MedalType = ID_MedalType;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }
    
    
}
