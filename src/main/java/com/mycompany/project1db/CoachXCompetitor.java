/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class CoachXCompetitor {
    private int ID_CoachXCompetitor;
    private int ID_Coach;
    private int ID_Competitor;

    public CoachXCompetitor(int ID_CoachXCompetitor, int ID_Coach, int ID_Competitor) {
        this.ID_CoachXCompetitor = ID_CoachXCompetitor;
        this.ID_Coach = ID_Coach;
        this.ID_Competitor = ID_Competitor;
    }

    public int getID_CoachXCompetitor() {
        return ID_CoachXCompetitor;
    }

    public void setID_CoachXCompetitor(int ID_CoachXCompetitor) {
        this.ID_CoachXCompetitor = ID_CoachXCompetitor;
    }

    public int getID_Coach() {
        return ID_Coach;
    }

    public void setID_Coach(int ID_Coach) {
        this.ID_Coach = ID_Coach;
    }

    public int getID_Competitor() {
        return ID_Competitor;
    }

    public void setID_Competitor(int ID_Competitor) {
        this.ID_Competitor = ID_Competitor;
    }
    
    
}
