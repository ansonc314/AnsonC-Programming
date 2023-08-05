package module3_4Sorting;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerSorterTest extends TestCase {
    public static ArrayList<PlayerBattingStats> players;
    @Test
    public void testSort()  throws FileNotFoundException {
        players = new ArrayList<PlayerBattingStats>();
        try {
            parseCSVData(new File("PlayerData.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<PlayerBattingStats>  players_sorted = new ArrayList<PlayerBattingStats>();
        players_sorted   = PlayerSorter.sort(players,0);

        assertEquals(115, players_sorted.get(0).getGames());
        assertEquals(115, players_sorted.get(1).getGames());
        assertEquals(115, players_sorted.get(2).getGames());
        assertEquals(114, players_sorted.get(3).getGames());


     }

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
}