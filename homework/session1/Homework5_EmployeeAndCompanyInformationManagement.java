/*
 * Category C Assignment - Problem M5: Employee and Company Information Management
 * A static field shared by every instance (companyName) instead of a
 * per-object copy, plus a static counter incremented by the constructor.
 */
public class Homework5_EmployeeAndCompanyInformationManagement {
    public static void main(String[] args) {
        new CompanyEmployee("Nina", 45000);
        new CompanyEmployee("Omar", 52000);
        new CompanyEmployee("Priya", 61000);

        CompanyEmployee.printCompanyInfo();
    }
}

class CompanyEmployee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}
