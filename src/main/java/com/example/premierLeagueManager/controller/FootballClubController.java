package com.example.premierLeagueManager.controller;

import com.example.premierLeagueManager.model.FootballClub;
import com.example.premierLeagueManager.service.FootballClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class FootballClubController {

    @Autowired
    private FootballClubService footballClubService;

    @RequestMapping(value = "/clubData",method = RequestMethod.GET)
    public List<FootballClub> getClubs(){
        return footballClubService.getClubs();
    }
}
