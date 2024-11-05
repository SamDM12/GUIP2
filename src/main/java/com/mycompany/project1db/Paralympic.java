/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Paralympic {
    private int ID_Paralympic;
    private int Year;
    private int ID_Country;

    public Paralympic(int ID_Paralympic, int Year, int ID_Country) {
        this.ID_Paralympic = ID_Paralympic;
        this.Year = Year;
        this.ID_Country = ID_Country;
    }

    public int getID_Paralympic() {
        return ID_Paralympic;
    }

    public void setID_Paralympic(int ID_Paralympic) {
        this.ID_Paralympic = ID_Paralympic;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getID_Country() {
        return ID_Country;
    }

    public void setID_Country(int ID_Country) {
        this.ID_Country = ID_Country;
    }
    
    
}
