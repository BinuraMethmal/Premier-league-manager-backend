package com.example.premierLeagueManager.service;

import com.example.premierLeagueManager.PremierLeagueManager;
import com.example.premierLeagueManager.PremierLeagueManagerApplication;
import com.example.premierLeagueManager.model.FootballClub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballClubService {

    public List<FootballClub> getClubs(){
        return PremierLeagueManager.clubData;

    }
}
