/*
 * Assignment Problem 3: College Fee Counter
 * Tuition is defined per student type; bus usage is a BusUser interface holding the single transport fee.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework3_CollegeFeeCounter {

    interface BusUser {
        double TRANSPORT_FEE = 12000;
    }

    abstract static class Student {
        protected static final double NORMAL_TUITION = 40000;
        protected final String name;

        Student(String name) {
            this.name = name;
        }

        abstract double tuitionAndCharges();

        final double totalFee() {
            double fee = tuitionAndCharges();
            if (this instanceof BusUser) {
                fee += BusUser.TRANSPORT_FEE;
            }
            return fee;
        }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String n) { super(n); }
        double tuitionAndCharges() { return NORMAL_TUITION; }
    }

    static class Hosteller extends Student {
        private static final double HOSTEL_FEE = 60000;

        Hosteller(String n) { super(n); }
        double tuitionAndCharges() { return NORMAL_TUITION + HOSTEL_FEE; }
    }

    static class ScholarshipStudent extends Student implements BusUser {
        ScholarshipStudent(String n) { super(n); }
        double tuitionAndCharges() { return NORMAL_TUITION / 2; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            switch (type) {
                case "DAY_SCHOLAR": students.add(new DayScholar(name)); break;
                case "HOSTELLER": students.add(new Hosteller(name)); break;
                case "SCHOLAR": students.add(new ScholarshipStudent(name)); break;
                default: throw new IllegalArgumentException("Unknown student type: " + type);
            }
        }
        double total = 0;
        for (Student student : students) {
            double fee = student.totalFee();
            total += fee;
            System.out.printf("%s: %.2f%n", student.name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
