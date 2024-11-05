/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Competitor {
    private int ID_Competitor;
    private int clasification_score;
    private int ID_Person;
    private int ID_Team;

    public Competitor(int ID_Competitor, int clasification_score, int ID_Person, int ID_Team) {
        this.ID_Competitor = ID_Competitor;
        this.clasification_score = clasification_score;
        this.ID_Person = ID_Person;
        this.ID_Team = ID_Team;
    }

    public int getID_Competitor() {
        return ID_Competitor;
    }

    public void setID_Competitor(int ID_Competitor) {
        this.ID_Competitor = ID_Competitor;
    }

    public int getClasification_score() {
        return clasification_score;
    }

    public void setClasification_score(int clasification_score) {
        this.clasification_score = clasification_score;
    }

    public int getID_Person() {
        return ID_Person;
    }

    public void setID_Person(int ID_Person) {
        this.ID_Person = ID_Person;
    }

    public int getID_Team() {
        return ID_Team;
    }

    public void setID_Team(int ID_Team) {
        this.ID_Team = ID_Team;
    }
    
    
}
