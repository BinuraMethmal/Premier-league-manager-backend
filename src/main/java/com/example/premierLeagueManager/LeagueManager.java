package com.example.premierLeagueManager;

import com.example.premierLeagueManager.model.Match;

import java.io.IOException;
import java.net.URISyntaxException;

public interface LeagueManager {

    public void openCLI() throws IOException, ClassNotFoundException, URISyntaxException;
    public void addClub();
    public void deleteClub();
    public void displayStats();
    public void addMatch();
    public void sortData();
    public Match randomMatch();
    public void statsTableCLI();
    public void saveData() throws IOException;
    public void loadData() throws IOException, ClassNotFoundException;
}
