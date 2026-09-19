/*
 * Category C - Problem 5: Placement Drive Shortlisting & Ranking Engine
 * Overloaded eligibility checks (CGPA-only vs CGPA+coding-score), and a
 * Comparable Candidate ranked with Arrays.sort() by composite score.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5_PlacementDriveShortlistingAndRankingEngine {

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }

    private static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (Candidate.isEligible(candidate.cgpa) || Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted.add(candidate);
            }
        }

        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(shortlistedArray[i].name)
                    .append(" (").append(shortlistedArray[i].compositeScore()).append(")");
        }
        return result.toString();
    }
}

class Candidate implements Comparable<Candidate> {
    private static final double CGPA_ONLY_THRESHOLD = 7.0;
    private static final double BORDERLINE_CGPA_THRESHOLD = 6.5;
    private static final int BORDERLINE_CODING_SCORE_THRESHOLD = 60;

    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= CGPA_ONLY_THRESHOLD;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= BORDERLINE_CGPA_THRESHOLD && codingScore >= BORDERLINE_CODING_SCORE_THRESHOLD;
    }

    double compositeScore() {
        return (cgpa * 10) + (codingScore / 2.0);
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore(), this.compositeScore());
    }
}
