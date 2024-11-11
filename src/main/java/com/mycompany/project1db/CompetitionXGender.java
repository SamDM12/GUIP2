/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

import java.util.ArrayList;

/**
 *
 * @author chedr
 */
public class CompetitionXGender {
    String competitionName;
    ArrayList<GenderType> genders;

    public CompetitionXGender(String competitionName, ArrayList<GenderType> genders) {
        this.competitionName = competitionName;
        this.genders = genders;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public ArrayList<GenderType> getGenders() {
        return genders;
    }
    
    
}
    