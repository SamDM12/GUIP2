/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class Team {
    private String TeamName;
    private int QuantityMembers;

    public Team(String TeamName, int ID_Team) {
        this.TeamName = TeamName;
        this.QuantityMembers = QuantityMembers;
    }
    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }

    public int getQuantityMembers() {
        return QuantityMembers;
    }

    public void setQuantityMembers(int QuantityMembers) {
        this.QuantityMembers = QuantityMembers;
    }
    
    
}
