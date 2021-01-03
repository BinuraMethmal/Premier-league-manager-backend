package com.example.premierLeagueManager.controller;


import com.example.premierLeagueManager.model.Match;
import com.example.premierLeagueManager.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MatchController {
    @Autowired
    private MatchService matchController;

    @RequestMapping(value = "/matchData", method = RequestMethod.GET)
    public List<Match> getMatchTable(){
        return matchController.getMatchData();
    }

    @RequestMapping(value = "/randomMatch", method = RequestMethod.GET)
    public Match randomMatchGenerated(){
        return matchController.generateRandomMatch();
    }

}
