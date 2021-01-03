package com.example.premierLeagueManager;

import com.example.premierLeagueManager.model.*;
import com.example.premierLeagueManager.model.Date;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class PremierLeagueManager implements LeagueManager{

    // Declare some class variables
    public static int winPoints = 3;
    public static int drawPoints = 1;


    // Arrays for store Objects temporary
    public static ArrayList<FootballClub> clubData = new ArrayList<>(); // --> Football Clubs Details
    public static ArrayList<Match> matchData = new ArrayList<>(); // --> Matches Details
    public static ArrayList<SportsClub> normalClub = new ArrayList<>(); // --> Normal Clubs Details


    public void openCLI() throws IOException, ClassNotFoundException, URISyntaxException {
        loadData(); // Load past objects -> Array List
        sortData();

        // Main Menu
        while (true) {
            Scanner myObj = new Scanner(System.in);

            // Labels for every input options
            System.out.print("\n");
            System.out.println("Enter your Option.");
            System.out.println("'C' for Add new Club. ");
            System.out.println("'M' for Add Played Match. ");
            System.out.println("'S' for Display Club Statistics.");
            System.out.println("'P' for Display Premier League Table in CLI.");
            System.out.println("'G' for Display Premier League Table in GUI.");
            System.out.println("'D' for Delete Club.");
            System.out.println("'Q' for Quit.");
            System.out.print("Your Option: ");

            // Take user option
            String option = myObj.nextLine().toUpperCase();
            System.out.print("\n");

            switch (option) {
                case "C":
                    addClub();
                    break;
                case "M":
                    addMatch();
                    break;

                case "S":
                    displayStats();
                    break;

                case "P":
                    statsTableCLI();
                    break;

                case "G":
                    URL();
                    break;

                case "D":
                    deleteClub();
                    break;
                case "Q":
                    saveData();
                    System.exit(0);
                    break;
            }

        }
    }

    public void URL() throws URISyntaxException, IOException {
        System.setProperty("java.awt.headless", "false");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://localhost:4200/"));
    }

    // Add new club method
    public void addClub(){

        String[] location = new String[4];

        while (true) {
            Scanner myObj = new Scanner(System.in);

            // User option 1
            System.out.println("Enter- ");
            System.out.println("'F' for Foot Ball Club ");
            System.out.println("'O' for Other Club ");
            System.out.print("Your Option: ");

            String option1 = myObj.nextLine().toUpperCase();
            System.out.print("\n");

            // Take user inputs for Common data for every club
            if (option1.equalsIgnoreCase("F") || option1.equalsIgnoreCase("O")) {

                // User option 2 Uni Club or School Club
                if (option1.equalsIgnoreCase("F")) {


                    System.out.println("Enter- ");
                    System.out.println("'N' for Normal Foot Ball Club ");
                    System.out.println("'U' for University Foot Ball Club ");
                    System.out.println("'S' for School Foot Ball Club ");
                    System.out.print("Your Option: ");

                    String option2 = myObj.nextLine().toUpperCase();

                    // Take user inputs for Foot ball club
                    if (option2.equalsIgnoreCase("N")||option2.equalsIgnoreCase("U") ||
                            option2.equalsIgnoreCase("S")) {

                        System.out.print("Enter your Club name- ");
                        String name = myObj.nextLine();

                        System.out.println("Enter your location of the Club - ");
                        System.out.print("Address Line 01 - ");
                        location[0] = myObj.nextLine();
                        System.out.print("City - ");
                        location[1] = myObj.nextLine();
                        System.out.print("Zip Code - ");
                        location[2] = myObj.nextLine();
                        System.out.print("Country - ");
                        location[3] = myObj.nextLine();

                        if (option2.equalsIgnoreCase("N")) {

                            FootballClub club = new FootballClub();

                            // Set Default values
                            club.setClubName(name);
                            club.setClubAddress1(location[0]);
                            club.setClubCity(location[1]);
                            club.setClubZipCode(location[2]);
                            club.setClubCountry(location[3]);
                            clubData.add(club);

                            // Take user inputs for University Club
                        }else if (option2.equalsIgnoreCase("U")) {


                            UniversityFootballClub club = new UniversityFootballClub();

                            // Set Default values
                            club.setClubName(name);
                            club.setClubAddress1(location[0]);
                            club.setClubCity(location[1]);
                            club.setClubZipCode(location[2]);
                            club.setClubCountry(location[3]);

                            System.out.print("Enter your University Name- ");
                            String uniName = myObj.nextLine();
                            club.setUniversityName(uniName);

                            System.out.print("Enter your University Location- ");
                            String uniLocation = myObj.nextLine();
                            club.setUniversityLocation(uniLocation);

                            clubData.add(club);

                            // Take user inputs for School Club
                        } else if (option2.equalsIgnoreCase("S")) {

                            SchoolFootballClub club = new SchoolFootballClub();

                            // Set Default values
                            club.setClubName(name);
                            club.setClubAddress1(location[0]);
                            club.setClubCity(location[1]);
                            club.setClubZipCode(location[2]);
                            club.setClubCountry(location[3]);

                            System.out.print("Enter your School Name- ");
                            String sclName = myObj.nextLine();
                            club.setSchoolName(sclName);

                            System.out.print("Enter your School Location- ");
                            String sclLocation = myObj.nextLine();
                            club.setSchoolLocation(sclLocation);

                            clubData.add(club);
                        } else {
                            System.out.println("** Invalid Input **");
                        }

                        break;
                    }

                    // Take other clubs inputs
                } else if (option1.equalsIgnoreCase("O")) {

                    System.out.print("Enter your Club name- ");
                    String name = myObj.nextLine();

                    System.out.println("Enter your location of the Club - ");
                    System.out.print("Address Line 01 - ");
                    location[0] = myObj.nextLine();
                    System.out.print("City - ");
                    location[1] = myObj.nextLine();
                    System.out.print("Zip Code - ");
                    location[2] = myObj.nextLine();
                    System.out.print("Country - ");
                    location[3] = myObj.nextLine();


                    SportsClub club = new SportsClub();
                    club.setClubName(name);
                    club.setClubAddress1(location[0]);
                    club.setClubCity(location[1]);
                    club.setClubZipCode(location[2]);
                    club.setClubCountry(location[3]);

                    normalClub.add(club);

                } else {
                    System.out.println("** Invalid Input. Try Again! **\n");
                }
            } else {
                System.out.println("** Invalid Input. Try Again! **\n");
            }
        }
    }

    // Delete Club method
    public void deleteClub(){

        // Take name of the club which is need to delete
        System.out.println("Enter Club name to Delete: ");
        Scanner myObj = new Scanner(System.in);
        String option = myObj.nextLine();


        for (FootballClub club:clubData){
            // Verify Club name from clubDate Array
            if (club.getClubName().equals(option)){
                clubData.remove(club); // remove specific club
                System.out.println("Club "+ club.getClubName()+" removed");
                return;
            }
        }
        System.out.println("** This System haven't a Club called "+ option +". **");

    }

    // Display club statistics method
    public void displayStats(){

        Scanner myObj = new Scanner(System.in);
        String clubName;
        System.out.print("Enter club Name: ");
        clubName = myObj.nextLine();

        for (FootballClub club:clubData){
            // Verify Club name from clubDate Array
            if (club.getClubName().equals(clubName)){

                String name = club.getClubName();
                int wins = club.getClubWins();
                int draws = club.getClubDraws();
                int defeat = club.getClubDefeats();
                int scoredGoals = club.getClubGoalsScored();
                int receivedGoals = club.getClubGoalsReceived();
                double points = club.getClubPoints();
                int matches = club.getClubMatches();

                System.out.println("Club Statistics: "+ name + "\n Wins: " + wins + "\n Draws: " + draws + "\n Defeats: " + defeat +
                        "\n Scored Goals: " + scoredGoals + "\n Received Goals: " + receivedGoals + "\n Points: " + points + "\n Matches: " + matches+"\n");

                return;
            }
        }
        System.out.println("** This System haven't a Club called "+ clubName +". **");
    }

    // Add Played match method
    public void addMatch(){

        int team1GoalsReceived =0;
        int team2GoalsReceived =0;
        int team1GoalsScored = 0;
        int team2GoalsScored = 0;

        Date date = null;
        String teamOne;
        String teamTwo;

        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter Team One: ");
        teamOne = myObj.nextLine();

        FootballClub firstTeam = null;
        for(FootballClub club : clubData){
            if(club.getClubName().equals(teamOne))
                firstTeam = club;
        }

        if (firstTeam == null) {
            System.out.println("** This kind club not Registered in system. **");
            return;
        }

        System.out.print("Enter Team Two: ");
        teamTwo = myObj.nextLine();

        FootballClub secondTeam = null;
        for(FootballClub club : clubData){
            if(club.getClubName().equals(teamTwo))
                secondTeam = club;
        }

        if (secondTeam == null) {
            System.out.println("** This kind club not Registered in system. **");
            return;
        }

        while (true) {

            // Enter Match Date
            System.out.print("Enter Match date (Format - 'DD/MM/YYYY'): ");
            String matchDate = myObj.nextLine();

            // Check date is in right format
            try {
                date = new Date(matchDate);

            } catch (IllegalArgumentException e) {
                continue;

            }

            // Enter Team 1 Score
            System.out.println("Enter Number of Team One Scored Goals: ");

            // Check score is in correct data type (Double)
            try {
                team1GoalsScored = myObj.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("** Double Value Required! **");
            }

            // Enter Team 2 Score
            System.out.println("Enter Number of Team Two Scored Goals: ");

            // Check score is in correct data type (Double)
            try {
                team2GoalsScored = myObj.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("** Double Value Required! **");
            }

            // Enter Team 1 Goals
            System.out.println("Enter Team One Received goals: ");

            try {
                team1GoalsReceived = myObj.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("** You have to enter number of Goals. It should be integer value! **");
            }

            // Enter Team 2 Goals
            System.out.println("Enter Team Two Received goals: ");

            try {
                team2GoalsReceived = myObj.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("** You have to enter number of Goals. It should be integer value! **");
            }


            Match match = new Match();
            match.setMatchDate(date);
            match.setTeamOne(teamOne);
            match.setTeamTwo(teamTwo);
            match.setTeam1GoalsScored(team1GoalsScored);
            match.setTeam2GoalsScored(team2GoalsScored);
            match.setTeam2GoalsReceived(team1GoalsReceived);
            match.setTeam2GoalsReceived(team2GoalsReceived);
            match.setManual(true);

            matchData.add(match);

            firstTeam.setClubGoalsReceived(firstTeam.getClubGoalsReceived() + team1GoalsReceived);
            secondTeam.setClubGoalsReceived(secondTeam.getClubGoalsReceived() + team2GoalsReceived);
            firstTeam.setClubGoalsScored(firstTeam.getClubGoalsScored() + team1GoalsScored);
            secondTeam.setClubGoalsScored(secondTeam.getClubGoalsScored() + team2GoalsScored);

            firstTeam.setClubMatches(firstTeam.getClubMatches()+1);
            secondTeam.setClubMatches(secondTeam.getClubMatches()+1);

            if (team1GoalsScored > team2GoalsScored) {
                firstTeam.setClubWins(firstTeam.getClubWins()+1);
                secondTeam.setClubDefeats(secondTeam.getClubDefeats()+1);
                firstTeam.setClubPoints(firstTeam.getClubPoints()+winPoints);

            } else if (team1GoalsScored < team2GoalsScored) {
                secondTeam.setClubWins(secondTeam.getClubWins()+1);
                firstTeam.setClubDefeats(firstTeam.getClubDefeats()+1);
                secondTeam.setClubPoints(secondTeam.getClubPoints()+winPoints);

            } else {
                firstTeam.setClubDraws(firstTeam.getClubDraws()+1);
                secondTeam.setClubDraws(secondTeam.getClubDraws()+1);
                firstTeam.setClubPoints(firstTeam.getClubPoints()+drawPoints);
                secondTeam.setClubPoints(secondTeam.getClubPoints()+drawPoints);
            }
            break;
        }

    }

    // Data Sorting and Display Table in CLI Method
    public void sortData(){

        clubData.sort(new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub o1, FootballClub o2) {
                int result;

                // Compare 1st point to 2nd point
                Double x = o1.getClubPoints();
                Double y = o2.getClubPoints();

                result = y.compareTo(x);

                // when both points are equal comparing with Goals
                if (x.equals(y)){

                    Integer p = o1.getClubGoalsScored();
                    Integer q = o2.getClubGoalsScored();

                    result = q.compareTo(p);

                }
                return result;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
    }

    // Display Statistics in a Table using CLI
    public void statsTableCLI(){

        if (clubData.size()>0){

            sortData();

            // Print some of attributes of the table after sorted
            for (FootballClub club: clubData){
                System.out.println(
                        "Club Name: "+club.getClubName()+"\t"+
                        "Club Points: "+ club.getClubPoints()+ "\t" +
                        "Scored Goals: "+club.getClubGoalsScored()+"\t"+
                        "Received Goals: "+club.getClubGoalsReceived()+"\t"+
                        "Club Wins: "+club.getClubWins()+"\t"+
                        "Matches: "+ club.getClubMatches()+"\t");


            }
        } else {
            System.out.println("** No Clubs to Show Statistics.**");
        }

    }

    // Method for generate Random Match
    public Match randomMatch(){
        Match randomMatch = new Match();
        if (clubData.size() > 1) {
            ArrayList<Integer> teamIndexes = new ArrayList<>();

            //Generate random team indexes
            Random randomGenerator = new Random();
            while (teamIndexes.size() < 2) {

                int random = randomGenerator.nextInt(clubData.size());
                if (!teamIndexes.contains(random)) {
                    teamIndexes.add(random);
                }
            }

            //Generate Date
            java.util.Date utilToday = new java.util.Date();
            java.sql.Date today = new java.sql.Date(utilToday.getTime());
            String yearString = today.toString().split("-")[0];
            int year = randomGenerator.nextInt(( Integer.parseInt(yearString) + 1) - 2000) + 2000;
            int month = randomGenerator.nextInt(12) + 1;
            int date = randomGenerator.nextInt(31) + 1;
            Date finalDate = new Date(date + "/" + month + "/" + year);

            //Generate Statistics
            int team1ScoredGoals = randomGenerator.nextInt(10);
            int team2ScoredGoals = randomGenerator.nextInt(10);
            int team1ReceivedGoals = team2ScoredGoals;
            int team2ReceivedGoals = team1ScoredGoals;

            // Make Match object for Random match
            randomMatch.setMatchDate(finalDate);
            randomMatch.setTeamOne(clubData.get(teamIndexes.get(0)).getClubName());
            randomMatch.setTeamTwo(clubData.get(teamIndexes.get(1)).getClubName());
            randomMatch.setTeam1GoalsScored(team1ScoredGoals);
            randomMatch.setTeam2GoalsScored(team2ScoredGoals);
            randomMatch.setTeam1GoalsReceived(team1ReceivedGoals);
            randomMatch.setTeam2GoalsReceived(team2ReceivedGoals);
            randomMatch.setManual(false);

            matchData.add(randomMatch); // Add Random match --> matchData
            //System.out.println(randomMatch.toString());

            // Update Statistics
            clubData.get(teamIndexes.get(0)).setClubGoalsScored(clubData.get(teamIndexes.get(0)).getClubGoalsScored() + team1ScoredGoals);
            clubData.get(teamIndexes.get(1)).setClubGoalsScored(clubData.get(teamIndexes.get(1)).getClubGoalsScored() + team2ScoredGoals);
            clubData.get(teamIndexes.get(0)).setClubGoalsReceived(clubData.get(teamIndexes.get(0)).getClubGoalsReceived() + team1ReceivedGoals);
            clubData.get(teamIndexes.get(1)).setClubGoalsReceived(clubData.get(teamIndexes.get(1)).getClubGoalsReceived() + team2ReceivedGoals);
            clubData.get(teamIndexes.get(0)).setClubMatches(clubData.get(teamIndexes.get(0)).getClubMatches() + 1);
            clubData.get(teamIndexes.get(1)).setClubMatches(clubData.get(teamIndexes.get(1)).getClubMatches() + 1);

            if (team1ScoredGoals > team2ScoredGoals) {

                clubData.get(teamIndexes.get(0)).setClubWins(clubData.get(teamIndexes.get(0)).getClubWins() + 1);
                clubData.get(teamIndexes.get(1)).setClubDefeats(clubData.get(teamIndexes.get(1)).getClubDefeats() + 1);
                clubData.get(teamIndexes.get(0)).setClubPoints(clubData.get(teamIndexes.get(0)).getClubPoints() + winPoints);

            } else if (team1ScoredGoals < team2ScoredGoals) {

                clubData.get(teamIndexes.get(1)).setClubWins(clubData.get(teamIndexes.get(1)).getClubWins() + 1);
                clubData.get(teamIndexes.get(0)).setClubDefeats(clubData.get(teamIndexes.get(0)).getClubDefeats() + 1);
                clubData.get(teamIndexes.get(1)).setClubPoints(clubData.get(teamIndexes.get(1)).getClubPoints() + winPoints);

            } else {
                clubData.get(teamIndexes.get(0)).setClubPoints(clubData.get(teamIndexes.get(0)).getClubPoints() + drawPoints);
                clubData.get(teamIndexes.get(1)).setClubPoints(clubData.get(teamIndexes.get(1)).getClubPoints() + drawPoints);

            }
        } else {
            return null;
        }
        return randomMatch;
    }

    // Method for Save data to Local file
    public void saveData()throws IOException {

        try {

            // Write Club details into txt file
            File file1 = new File("src/tempFiles/Club_Data.txt");
            file1.createNewFile();

            FileOutputStream fileOut1 = new FileOutputStream(file1, false);
            ObjectOutputStream objOut1 = new ObjectOutputStream(fileOut1);

            objOut1.writeObject(clubData);

            fileOut1.close();
            objOut1.close();

            // Write Match Data into txt file
            File file2 = new File("src/tempFiles/Match_Data.txt");
            file2.createNewFile();

            FileOutputStream fileOut2 = new FileOutputStream(file2, false);
            ObjectOutputStream objOut2 = new ObjectOutputStream(fileOut2);

            objOut2.writeObject(matchData);

            fileOut2.close();
            objOut2.close();

        } catch ( IOException i){
            i.printStackTrace();
        }
    }

    // Method to Load data from saved file
    public void loadData() throws IOException, ClassNotFoundException{
        try {
            FileInputStream fileIn1 = new FileInputStream("src/tempFiles/Club_Data.txt");
            FileInputStream fileIn2 = new FileInputStream("src/tempFiles/Match_Data.txt");

            if (fileIn1 != null && fileIn2 != null) {
                ObjectInputStream objIn1 = new ObjectInputStream(fileIn1);
                ObjectInputStream objIn2 = new ObjectInputStream(fileIn2);

                ArrayList<FootballClub> tempClubData = (ArrayList<FootballClub>) objIn1.readObject();
                clubData = tempClubData;
                fileIn1.close();
                objIn1.close();

                ArrayList<Match> tempMatchData = (ArrayList<Match>) objIn2.readObject();
                matchData = tempMatchData;
                fileIn2.close();
                fileIn2.close();
            }
        } catch (IOException e) {
            System.out.println("** Welcome to the Premier League Manager ** \n ** No Data Found **");
        }
    }
}
