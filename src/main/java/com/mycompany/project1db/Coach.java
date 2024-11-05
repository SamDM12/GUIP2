/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Coach {
    private int ID_Coach;
    private int ID_Person;
    private int ID_Team;

    public Coach(int ID_Coach, int ID_Person, int ID_Team) {
        this.ID_Coach = ID_Coach;
        this.ID_Person = ID_Person;
        this.ID_Team = ID_Team;
    }

    public int getID_Coach() {
        return ID_Coach;
    }

    public void setID_Coach(int ID_Coach) {
        this.ID_Coach = ID_Coach;
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
