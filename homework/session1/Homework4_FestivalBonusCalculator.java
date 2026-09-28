/*
 * Assignment Problem 4: The Festival Bonus Calculator
 * Employees share name and salary in the base class; each type overrides bonus().
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework4_FestivalBonusCalculator {

    abstract static class Employee {
        protected final String name;
        protected final double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double bonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String n, double s) { super(n, s); }
        double bonus() { return monthlySalary * 0.10; }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String n, double s) { super(n, s); }
        double bonus() { return monthlySalary * 0.05; }
    }

    static class Intern extends Employee {
        Intern(String n, double s) { super(n, s); }
        double bonus() { return 2000; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            switch (type) {
                case "FULLTIME": employees.add(new FullTimeEmployee(name, salary)); break;
                case "PARTTIME": employees.add(new PartTimeEmployee(name, salary)); break;
                case "INTERN": employees.add(new Intern(name, salary)); break;
                default: throw new IllegalArgumentException("Unknown employee type: " + type);
            }
        }
        double total = 0;
        for (Employee employee : employees) {
            double bonus = employee.bonus();
            total += bonus;
            System.out.printf("%s: %.2f%n", employee.name, bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
