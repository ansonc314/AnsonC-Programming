package module3_4Sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<PlayerBattingStats> players;

    /**
     * Takes in a comma sperated values file and parses the data.  It takes the data and
     * creates a PlayerBattingStats object and adds it to the players list.  The CSV file
     * must be in the format of:
     * Name,Team,Gamesplayed,At bats, runs, hits, doubles, triples, home runs, rbi's
     * @param file containg the data
     */
    public static void parseCSVData(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splitter = line.split(",");
            String name = splitter[0];
            String team = splitter[1];
            int gamesPlayed = Integer.parseInt(splitter[2]);
            int atBats = Integer.parseInt(splitter[3]);
            int runs = Integer.parseInt(splitter[4]);
            int hits = Integer.parseInt(splitter[5]);
            int doubles = Integer.parseInt(splitter[6]);
            int triples = Integer.parseInt(splitter[7]);
            int homeRunes = Integer.parseInt(splitter[8]);
            int rbis = Integer.parseInt(splitter[9]);
            players.add(new PlayerBattingStats(name, team, gamesPlayed, atBats, runs, hits, doubles, triples, homeRunes, rbis));
        }

    }

    public static void main(String[] args) throws IOException {
        players = new ArrayList<PlayerBattingStats>();
        try {
            parseCSVData(new File("PlayerData.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println( "Select your sorting criteria. \n(The player statistics will be sorted in descending order):" );
        System.out.println( "Enter 0: Sort according to GAMESPLAYED" );
        System.out.println( "Enter 1: Sort according to ATBATS" );
        System.out.println( "Enter 2: Sort according to RUNS" );
        System.out.println( "Enter 3: Sort according to PERCENTRUNS" );
        System.out.println( "Enter 4: Sort according to PERCENTONBASE" );
        System.out.println( "Enter 5: Create 1 single report, sorted according to all 5 criteria" );

        System.out.print( "Enter your choice: " );
        Scanner choice = new Scanner( System.in );
        int input = choice.nextInt();

        ArrayList<PlayerBattingStats> players_sorted = new ArrayList<PlayerBattingStats>();
        if (input<5) {
            players_sorted = PlayerSorter.sort(players, input);

            ArrayList<String> sortedList = new ArrayList<String>();
            for (PlayerBattingStats p : players_sorted) {
                sortedList.add(p.toString());
            }

            Write2File.write2txt("report.txt", sortedList);
            System.out.print("\nThe sorted output will be stored in the file report.txt ");
        }
        else{
            ArrayList<String> sortedList = new ArrayList<String>();

            /* sorted based on GAMESPLAYED */
                players_sorted = PlayerSorter.sort(players, 0);
                sortedList.add("Sorted according to GAMESPLAYED");
            for (PlayerBattingStats p : players_sorted) {
                sortedList.add(p.toString());
            }
                sortedList.add("\n\n");

            /* sorted based on ATBATS */
            players_sorted = PlayerSorter.sort(players, 1);
            sortedList.add("Sorted according to ATBATS");
            for (PlayerBattingStats p : players_sorted) {
                sortedList.add(p.toString());
            }
            sortedList.add("\n\n");

            /* sorted based on RUNS */
            players_sorted = PlayerSorter.sort(players, 2);
            sortedList.add("Sorted according to RUNS");
            for (PlayerBattingStats p : players_sorted) {
                sortedList.add(p.toString());
            }
            sortedList.add("\n\n");


            /* sorted based on PERCENTRUNS */
            players_sorted = PlayerSorter.sort(players, 3);
            sortedList.add("Sorted according to PERCENTRUNS");
            for (PlayerBattingStats p : players_sorted) {
                sortedList.add(p.toString());
            }
            sortedList.add("\n\n");

            /* sorted based on PERCENTONBASE */
            players_sorted = PlayerSorter.sort(players, 4);
            sortedList.add("Sorted according to PERCENTONBASE");
            for (PlayerBattingStats p : players_sorted) {
                sortedList.add(p.toString());
            }
            sortedList.add("\n\n");

            Write2File.write2txt("report.txt", sortedList);
            System.out.print("\nThe sorted output will be stored in the file report.txt ");
        }

    }
}
