/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Person {
    private int idDB;
    private int id;
    private String firstName;
    private String firstLastName;
    
    public Person(int id, String firstName, String firstLastName) {
        this.id = id;
        this.firstName = firstName;
        this.firstLastName = firstLastName;
    }

    public int getIdDB() {
        return idDB;
    }

    public void setIdDB(int idDB) {
        this.idDB = idDB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }


    
    
}
