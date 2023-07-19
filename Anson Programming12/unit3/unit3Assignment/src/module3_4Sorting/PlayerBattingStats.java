package module3_4Sorting;

/**
 * This class represents a players batting statistics.  The following are definitions of the stats
 * games -> Games played
 * atBAts -> Number of times a player has batted
 * runs -> Number of times a player reached home base
 * hits -> Number of times the player the ball and reached first base
 * doubles -> Number of times the player the ball and reached second base
 * triples -> Number of times the player the ball and reached second base
 * homeRuns -> Number of times the player got a home run
 * rbi -> Number of times the player got on base and allowed another runner to score
 */

public class PlayerBattingStats {
    private String name;
    private String team;
    private int games;
    private int atBats;
    private int runs;
    private int hits;
    private int doubles;
    private int triples;
    private int homeRuns;
    private int rbi;

    public PlayerBattingStats(String name, String team, int games, int atBats, int runs, int hits, int doubles, int triples, int homeRuns, int rbi) {
        this.name = name;
        this.team = team;
        this.games = games;
        this.atBats = atBats;
        this.runs = runs;
        this.hits = hits;
        this.doubles = doubles;
        this.triples = triples;
        this.homeRuns = homeRuns;
        this.rbi = rbi;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getGames() {
        return games;
    }

    public int getAtBats() {
        return atBats;
    }

    public int getRuns() {
        return runs;
    }

    public int getHits() {
        return hits;
    }

    public int getDoubles() {
        return doubles;
    }

    public int getTriples() {
        return triples;
    }

    public int getHomeRuns() {
        return homeRuns;
    }

    public int getRbi() {
        return rbi;
    }

    @Override
    public String toString() {
        return "PlayerBattingStats{" +
                String.format("%-30s" , "\tname='" + name + '\'') +
                "\t team='" + team + '\'' +
                "\t games=" + games +
                "\t atBats=" + atBats +
                "\t runs=" + runs +
                "\t hits=" + hits +
                "\t doubles=" + doubles +
                "\t triples=" + triples +
                String.format("%-15s" , "\t homeRuns=" + homeRuns ) +
                "\t rbi=" + rbi +
                '}';
    }


    public double getValue(int selector){
        double out = 0;
        switch (selector){
            case 0:
                out =  this.games;
                break;
            case 1:
                out =  this.atBats;
                break;
            case 2:
                out =  this.runs;
                break;
            case 3:
                out =  ((double) this.runs) / ((double) this.atBats);
                break;
            case 4:
                out =  ((double) (this.runs + this.doubles + this.triples  )) / ((double) this.atBats);
                break;

        }
        return out;
    }


}
