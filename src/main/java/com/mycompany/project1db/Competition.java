/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

import java.time.LocalDate;

/**
 *
 * @author samia
 */
public class Competition {
    private int ID_Competition;
    private int ID_CompetitionType;
    private String CompetitionName;
    private LocalDate CompetitionDate;
    private String Description;

    public Competition(int ID_Competition, int ID_CompetitionType, String CompetitionName, LocalDate CompetitionDate, String Description) {
        this.ID_Competition = ID_Competition;
        this.ID_CompetitionType = ID_CompetitionType;
        this.CompetitionName = CompetitionName;
        this.CompetitionDate = CompetitionDate;
        this.Description = Description;
    }

    public int getID_Competition() {
        return ID_Competition;
    }

    public void setID_Competition(int ID_Competition) {
        this.ID_Competition = ID_Competition;
    }

    public int getID_CompetitionType() {
        return ID_CompetitionType;
    }

    public void setID_CompetitionType(int ID_CompetitionType) {
        this.ID_CompetitionType = ID_CompetitionType;
    }

    public String getCompetitionName() {
        return CompetitionName;
    }

    public void setCompetitionName(String CompetitionName) {
        this.CompetitionName = CompetitionName;
    }

    public LocalDate getCompetitionDate() {
        return CompetitionDate;
    }

    public void setCompetitionDate(LocalDate CompetitionDate) {
        this.CompetitionDate = CompetitionDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
