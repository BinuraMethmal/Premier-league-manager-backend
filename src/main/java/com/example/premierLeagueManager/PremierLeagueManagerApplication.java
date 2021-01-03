package com.example.premierLeagueManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.URISyntaxException;

@SpringBootApplication
public class PremierLeagueManagerApplication {

	// Main method
	public static void main(String[] args) throws IOException, ClassNotFoundException, URISyntaxException {

		SpringApplication.run(PremierLeagueManagerApplication.class, args);

		PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
		premierLeagueManager.openCLI();

	}

}
