/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class NationalityXPerson {
    private int ID_NationalityXPerson;
    private int ID_Nationality;
    private int ID_Person;

    public NationalityXPerson(int ID_NationalityXPerson, int ID_Nationality, int ID_Person) {
        this.ID_NationalityXPerson = ID_NationalityXPerson;
        this.ID_Nationality = ID_Nationality;
        this.ID_Person = ID_Person;
    }

    public int getID_NationalityXPerson() {
        return ID_NationalityXPerson;
    }

    public void setID_NationalityXPerson(int ID_NationalityXPerson) {
        this.ID_NationalityXPerson = ID_NationalityXPerson;
    }

    public int getID_Nationality() {
        return ID_Nationality;
    }

    public void setID_Nationality(int ID_Nationality) {
        this.ID_Nationality = ID_Nationality;
    }

    public int getID_Person() {
        return ID_Person;
    }

    public void setID_Person(int ID_Person) {
        this.ID_Person = ID_Person;
    }
    
    
}
