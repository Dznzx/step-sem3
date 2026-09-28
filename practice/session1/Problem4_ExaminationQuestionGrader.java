/*
 * Problem 4: Examination Question Grader
 * Each question type overrides grade(); ESSAY awards partial credit by case-insensitive keyword matches.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem4_ExaminationQuestionGrader {

    abstract static class Question {
        protected final String correctAnswer;
        protected final String studentAnswer;
        protected final int points;

        Question(String correctAnswer, String studentAnswer, int points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract String type();

        abstract double grade();
    }

    static class McqQuestion extends Question {
        McqQuestion(String c, String s, int p) { super(c, s, p); }
        String type() { return "MCQ"; }
        double grade() { return studentAnswer.equals(correctAnswer) ? points : 0; }
    }

    static class TrueFalseQuestion extends Question {
        TrueFalseQuestion(String c, String s, int p) { super(c, s, p); }
        String type() { return "TF"; }
        double grade() { return studentAnswer.equals(correctAnswer) ? points : 0; }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String c, String s, int p) { super(c, s, p); }

        String type() { return "ESSAY"; }

        double grade() {
            String answer = studentAnswer.toLowerCase();
            int matches = 0;
            for (String keyword : correctAnswer.split(",")) {
                String cleaned = keyword.trim().toLowerCase();
                if (!cleaned.isEmpty() && answer.contains(cleaned)) {
                    matches++;
                }
            }
            if (matches >= 2) return points * 0.75;
            if (matches == 1) return points * 0.50;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        while (questions.size() < count) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            questions.add(parseQuestion(line));
        }
        double total = 0;
        for (Question question : questions) {
            double score = question.grade();
            total += score;
            System.out.printf("%s: %.2f%n", question.type(), score);
        }
        System.out.printf("Total Score: %.2f%n", total);
    }

    private static Question parseQuestion(String line) {
        List<String> tokens = tokenize(line);
        String type = tokens.get(0);
        String correct = tokens.get(2);
        String student = tokens.get(3);
        int points = Integer.parseInt(tokens.get(4));
        switch (type) {
            case "MCQ": return new McqQuestion(correct, student, points);
            case "TF": return new TrueFalseQuestion(correct, student, points);
            case "ESSAY": return new EssayQuestion(correct, student, points);
            default: throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    private static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ' ' && !inQuotes) {
                if (current.length() > 0) {
                    tokens.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }
        }
        if (current.length() > 0) {
            tokens.add(current.toString());
        }
        return tokens;
    }
}
