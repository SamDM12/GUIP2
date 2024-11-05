/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Disability {
    private int ID_Disability;
    private String DisabilityName;

    public Disability(int ID_Disability, String DisabilityName) {
        this.ID_Disability = ID_Disability;
        this.DisabilityName = DisabilityName;
    }

    public int getID_Disability() {
        return ID_Disability;
    }

    public void setID_Disability(int ID_Disability) {
        this.ID_Disability = ID_Disability;
    }

    public String getDisabilityName() {
        return DisabilityName;
    }

    public void setDisabilityName(String DisabilityName) {
        this.DisabilityName = DisabilityName;
    }
    
    
}
