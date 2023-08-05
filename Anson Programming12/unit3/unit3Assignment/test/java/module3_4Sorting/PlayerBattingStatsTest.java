package module3_4Sorting;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class PlayerBattingStatsTest extends TestCase {

    public static ArrayList<PlayerBattingStats> players = new ArrayList<>();
    String name = "player 1" ;
    String team = "team 1";
    int gamesPlayed = 50;
    int atBats = 20;
    int runs = 30;
    int hits = 15;
    int doubles = 5;
    int triples = 7;
    int homeRunes = 6;
    int rbis = 28;

    @Test
    public void testGetValue() {
        players.add(new PlayerBattingStats(name, team, gamesPlayed, atBats, runs, hits, doubles, triples, homeRunes, rbis));

        // check option 0 - get GAMESPLAYED
        assertEquals(50,players.get(0).getValue(0), 0.01);

            // check option 1 - get ATBATS
        assertEquals(20,players.get(0).getValue(1), 0.01);

        // check option 2 - get runs
        assertEquals(30,players.get(0).getValue(2), 0.01);

        // check option 3 - get PERCENTRUNS
        assertEquals(1.5,players.get(0).getValue(3), 0.01);

        // check option 4 - get PERCENTONBASE
        assertEquals(1.35,players.get(0).getValue(4), 0.01);

    }


}