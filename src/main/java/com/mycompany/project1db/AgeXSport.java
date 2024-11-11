/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author chedr
 */
public class AgeXSport {
    String competitionName;
    int inRange;
    int outRange;

    public AgeXSport(String competitionName, int inRange, int outRange) {
        this.competitionName = competitionName;
        this.inRange = inRange;
        this.outRange = outRange;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public int getInRange() {
        return inRange;
    }

    public int getOutRange() {
        return outRange;
    }
    
}
