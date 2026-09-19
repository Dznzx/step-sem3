/*
 * Category C Assignment - Problem 5: Fantasy League Auto-Draft Ranking Engine
 * Overloaded draftability checks (experience-only vs experience+fitness),
 * and a Comparable Player ranked by fantasy points with Arrays.sort().
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework5_FantasyLeagueAutoDraftRankingEngine {

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }

    private static String draftAndRank(Player[] players) {
        List<Player> draftable = new ArrayList<>();
        for (Player player : players) {
            if (Player.isDraftable(player.matchesPlayed) || Player.isDraftable(player.matchesPlayed, player.injured)) {
                draftable.add(player);
            }
        }

        Player[] draftableArray = draftable.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(draftableArray[i].name);
        }
        return result.toString();
    }
}

class Player implements Comparable<Player> {
    private static final int EXPERIENCE_ONLY_THRESHOLD = 10;
    private static final int BORDERLINE_MATCHES_THRESHOLD = 5;

    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= EXPERIENCE_ONLY_THRESHOLD;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= BORDERLINE_MATCHES_THRESHOLD && !injured;
    }

    private double fantasyPoints() {
        return battingAverage;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.fantasyPoints(), this.fantasyPoints());
    }
}
