/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Score {
    private int ID_Score;
    private int Quantity;
    private int ID_Competition;

    public Score(int ID_Score, int Quantity, int ID_Competition) {
        this.ID_Score = ID_Score;
        this.Quantity = Quantity;
        this.ID_Competition = ID_Competition;
    }

    public int getID_Score() {
        return ID_Score;
    }

    public void setID_Score(int ID_Score) {
        this.ID_Score = ID_Score;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getID_Competition() {
        return ID_Competition;
    }

    public void setID_Competition(int ID_Competition) {
        this.ID_Competition = ID_Competition;
    }
    
    
}
