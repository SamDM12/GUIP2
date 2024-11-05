/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class CompetitorXDisability {
    private int ID_CompetitorXDisability;
    private int ID_Competitor;
    private int ID_Disability;

    public CompetitorXDisability(int ID_CompetitorXDisability, int ID_Competitor, int ID_Disability) {
        this.ID_CompetitorXDisability = ID_CompetitorXDisability;
        this.ID_Competitor = ID_Competitor;
        this.ID_Disability = ID_Disability;
    }

    public int getID_CompetitorXDisability() {
        return ID_CompetitorXDisability;
    }

    public void setID_CompetitorXDisability(int ID_CompetitorXDisability) {
        this.ID_CompetitorXDisability = ID_CompetitorXDisability;
    }

    public int getID_Competitor() {
        return ID_Competitor;
    }

    public void setID_Competitor(int ID_Competitor) {
        this.ID_Competitor = ID_Competitor;
    }

    public int getID_Disability() {
        return ID_Disability;
    }

    public void setID_Disability(int ID_Disability) {
        this.ID_Disability = ID_Disability;
    }
    
    
}
