/*
 * Problem 2: Weekly Staff Pay
 * Staff is abstract so a generic staff member can never be created; each type implements weeklyPay().
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2_WeeklyStaffPay {

    abstract static class Staff {
        protected final String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double weeklyPay();
    }

    static class FullTimeStaff extends Staff {
        private final double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        double weeklyPay() { return weeklySalary; }
    }

    static class HourlyStaff extends Staff {
        private static final int REGULAR_HOURS = 40;
        private final double hours;
        private final double rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        double weeklyPay() {
            double regular = Math.min(hours, REGULAR_HOURS) * rate;
            double overtime = Math.max(0, hours - REGULAR_HOURS) * rate * 1.5;
            return regular + overtime;
        }
    }

    static class InternStaff extends Staff {
        private final double stipend;

        InternStaff(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        double weeklyPay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Staff> staff = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String name = scanner.next();
            switch (type) {
                case "FULLTIME": staff.add(new FullTimeStaff(name, scanner.nextDouble())); break;
                case "HOURLY": staff.add(new HourlyStaff(name, scanner.nextDouble(), scanner.nextDouble())); break;
                case "INTERN": staff.add(new InternStaff(name, scanner.nextDouble())); break;
                default: throw new IllegalArgumentException("Unknown staff type: " + type);
            }
        }
        double total = 0;
        for (Staff member : staff) {
            double pay = member.weeklyPay();
            total += pay;
            System.out.printf("%s: %.2f%n", member.name, pay);
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
