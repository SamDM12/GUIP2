/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class CountryXParalympic {
    private int ID_CountryXParalympic;
    private int ID_Country;
    private int ID_Paralympic;

    public CountryXParalympic(int ID_CountryXParalympic, int ID_Country, int ID_Paralympic) {
        this.ID_CountryXParalympic = ID_CountryXParalympic;
        this.ID_Country = ID_Country;
        this.ID_Paralympic = ID_Paralympic;
    }

    public int getID_CountryXParalympic() {
        return ID_CountryXParalympic;
    }

    public void setID_CountryXParalympic(int ID_CountryXParalympic) {
        this.ID_CountryXParalympic = ID_CountryXParalympic;
    }

    public int getID_Country() {
        return ID_Country;
    }

    public void setID_Country(int ID_Country) {
        this.ID_Country = ID_Country;
    }

    public int getID_Paralympic() {
        return ID_Paralympic;
    }

    public void setID_Paralympic(int ID_Paralympic) {
        this.ID_Paralympic = ID_Paralympic;
    }
    
    
}
