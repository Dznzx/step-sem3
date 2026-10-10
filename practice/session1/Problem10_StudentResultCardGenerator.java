/*
 * Problem 10: Student Result Card Generator
 * Student holds a name and three marks; prints the uppercase name, one-decimal average, and grade.
 */
import java.util.Scanner;

public class Problem10_StudentResultCardGenerator {

    static class Student {
        private final String name;
        private final int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double averageMark() {
            int sum = 0;
            for (int mark : marks) {
                sum += mark;
            }
            return (double) sum / marks.length;
        }

        char grade() {
            double average = averageMark();
            if (average >= 90) return 'A';
            if (average >= 75) return 'B';
            if (average >= 60) return 'C';
            if (average >= 40) return 'D';
            return 'F';
        }

        String resultCard() {
            return String.format("%s: Average %.1f, Grade %c", name.toUpperCase(), averageMark(), grade());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            int bracket = line.indexOf('[');
            String name = line.substring(0, bracket).trim();
            int[] marks = parseList(line.substring(bracket));
            System.out.println(new Student(name, marks).resultCard());
        }
    }

    private static int[] parseList(String line) {
        String inner = line.replace("[", "").replace("]", "").trim();
        if (inner.isEmpty()) {
            return new int[0];
        }
        String[] parts = inner.split("\\s*,\\s*");
        int[] values = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            values[i] = Integer.parseInt(parts[i].trim());
        }
        return values;
    }
}
