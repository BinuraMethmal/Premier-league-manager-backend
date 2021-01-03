package com.example.premierLeagueManager.model;

import java.io.Serializable;
import java.util.Objects;

public class UniversityFootballClub extends FootballClub implements Serializable {
    private String universityName;
    private String universityLocation;


    public UniversityFootballClub() {
        // Default constructor
    }

    // Overloading Constructor
    public UniversityFootballClub(String universityName, String universityLocation) {
        this.universityName = universityName;
        this.universityLocation = universityLocation;
    }


    // Setters
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }


    public void setUniversityLocation(String universityLocation) {
        this.universityLocation = universityLocation;
    }

    //Getters
    public String getUniversityName() {
        return universityName;
    }

    public String getUniversityLocation() {
        return universityLocation;
    }

    @Override
    public String toString() {
        return "UniversityFootballClub{" +
                "universityName='" + universityName + '\'' +
                ", universityLocation='" + universityLocation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UniversityFootballClub)) return false;
        if (!super.equals(o)) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return Objects.equals(getUniversityName(), that.getUniversityName()) &&
                Objects.equals(getUniversityLocation(), that.getUniversityLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUniversityName(), getUniversityLocation());
    }
}
