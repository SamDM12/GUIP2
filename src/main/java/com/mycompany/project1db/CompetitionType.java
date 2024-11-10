/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class CompetitionType {
    private String name;
    private int quantity;
    public CompetitionType(String Description, int quantity) {
        this.name = Description;
        this.quantity = quantity;
    }

    public String getDescription() {
        return name;
    }

    public void setDescription(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
