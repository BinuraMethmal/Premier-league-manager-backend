package com.example.premierLeagueManager.model;

import java.io.Serializable;
import java.util.Objects;

public class Match implements Serializable {

    private String teamOne;
    private String teamTwo;
    private Date matchDate;
    private int team1GoalsReceived;
    private int team2GoalsReceived;
    private int team1GoalsScored;
    private int team2GoalsScored;
    private boolean isManual;


    //Setters
    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public void setTeam1GoalsReceived(int team1GoalsReceived) {
        this.team1GoalsReceived = team1GoalsReceived;
    }

    public void setTeam2GoalsReceived(int team2GoalsReceived) {
        this.team2GoalsReceived = team2GoalsReceived;
    }

    public void setTeam1GoalsScored(int team1GoalsScored) {
        this.team1GoalsScored = team1GoalsScored;
    }

    public void setTeam2GoalsScored(int team2GoalsScored) {
        this.team2GoalsScored = team2GoalsScored;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    //Getters
    public String getTeamOne() {
        return teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public int getTeam1GoalsReceived() {
        return team1GoalsReceived;
    }

    public int getTeam2GoalsReceived() {
        return team2GoalsReceived;
    }

    public int getTeam1GoalsScored() {
        return team1GoalsScored;
    }

    public int getTeam2GoalsScored() {
        return team2GoalsScored;
    }

    public boolean isManual() {
        return isManual;
    }

    /*public boolean search(String searchTerm){
        if (matchDate.equals(searchTerm)) return true;
        else return false;
    }*/

    @Override
    public String toString() {
        return "Match{" +
                "Team One='" + teamOne + '\'' +
                ", Team Two='" + teamTwo + '\'' +
                ", DOF=" + matchDate +
                ", Team 1 Received Goals=" + team1GoalsReceived +
                ", Team 2 Received Goals=" + team2GoalsReceived +
                ", Team 1 Scored Goals=" + team1GoalsScored +
                ", Team 2 Scored Goals=" + team2GoalsScored +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;
        Match match = (Match) o;
        return getTeam1GoalsReceived() == match.getTeam1GoalsReceived() &&
                getTeam2GoalsReceived() == match.getTeam2GoalsReceived() &&
                getTeam1GoalsScored() == match.getTeam1GoalsScored() &&
                getTeam2GoalsScored() == match.getTeam2GoalsScored() &&
                isManual() == match.isManual() &&
                Objects.equals(getTeamOne(), match.getTeamOne()) &&
                Objects.equals(getTeamTwo(), match.getTeamTwo()) &&
                Objects.equals(getMatchDate(), match.getMatchDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeamOne(), getTeamTwo(), getMatchDate(), getTeam1GoalsReceived(), getTeam2GoalsReceived(), getTeam1GoalsScored(), getTeam2GoalsScored(), isManual());
    }
}
