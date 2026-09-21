/*
 * Category C - Problem 2: The Quiz Scorecard
 * Raw results stay in a private array; only the computed score is ever
 * exposed. Recording stops once the fixed question count is reached.
 */
public class Problem2_TheQuizScorecard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println(sc.getScore());
    }
}

class Scorecard {
    private final boolean[] results;
    private int recordedCount;

    Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    void recordAnswer(boolean isCorrect) {
        if (recordedCount >= results.length) {
            return;
        }
        results[recordedCount] = isCorrect;
        recordedCount++;
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}
