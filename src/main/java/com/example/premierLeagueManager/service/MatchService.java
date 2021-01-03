package com.example.premierLeagueManager.service;

import com.example.premierLeagueManager.PremierLeagueManager;
import com.example.premierLeagueManager.model.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    public List<Match> getMatchData(){
        return PremierLeagueManager.matchData;
    }

    public Match generateRandomMatch(){
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        Match match = premierLeagueManager.randomMatch();
        return match;
    }

}
