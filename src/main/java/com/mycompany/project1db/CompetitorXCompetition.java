/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;

/**
 *
 * @author samia
 */
public class CompetitorXCompetition {
    private int ID_CompetitorXCompetition;
    private int ID_Competitor;
    private int ID_Competition;
    private int Time;
    private int Score;
    private int Position;

    public CompetitorXCompetition(int ID_CompetitorXCompetition, int ID_Competitor, int ID_Competition, int Time, int Score, int Position) {
        this.ID_CompetitorXCompetition = ID_CompetitorXCompetition;
        this.ID_Competitor = ID_Competitor;
        this.ID_Competition = ID_Competition;
        this.Time = Time;
        this.Score = Score;
        this.Position = Position;
    }

    public int getID_CompetitorXCompetition() {
        return ID_CompetitorXCompetition;
    }

    public void setID_CompetitorXCompetition(int ID_CompetitorXCompetition) {
        this.ID_CompetitorXCompetition = ID_CompetitorXCompetition;
    }

    public int getID_Competitor() {
        return ID_Competitor;
    }

    public void setID_Competitor(int ID_Competitor) {
        this.ID_Competitor = ID_Competitor;
    }

    public int getID_Competition() {
        return ID_Competition;
    }

    public void setID_Competition(int ID_Competition) {
        this.ID_Competition = ID_Competition;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int Time) {
        this.Time = Time;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public int getPosition() {
        return Position;
    }

    public void setPosition(int Position) {
        this.Position = Position;
    }
    
    
}
