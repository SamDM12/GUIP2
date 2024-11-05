/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class CompetitionType {
    private int ID_CompetitionType;
    private String Description;

    public CompetitionType(int ID_CompetitionType, String Description) {
        this.ID_CompetitionType = ID_CompetitionType;
        this.Description = Description;
    }

    public int getID_CompetitionType() {
        return ID_CompetitionType;
    }

    public void setID_CompetitionType(int ID_CompetitionType) {
        this.ID_CompetitionType = ID_CompetitionType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
