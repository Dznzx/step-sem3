/*
 * Category C - Problem M5: Student and College Information Management
 * A static field shared by every instance (collegeName) instead of a
 * per-object copy, plus a static counter incremented by the constructor.
 */
public class Problem5_StudentAndCollegeInformationManagement {
    public static void main(String[] args) {
        new Student("Divya", 90);
        new Student("Arjun", 85);

        Student.printCollegeInfo();
    }
}

class Student {
    String name;
    int attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}
