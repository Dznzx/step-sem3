/*
 * Category C - Problem 5: The Attendance Sheet
 * Present-student names stay in a private array; only a count and a
 * yes/no lookup are exposed, never the array itself.
 */
public class Problem5_TheAttendanceSheet {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}

class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    void markPresent(String name) {
        if (isPresent(name) || presentCount >= presentStudents.length) {
            return;
        }
        presentStudents[presentCount] = name;
        presentCount++;
    }

    int getPresentCount() {
        return presentCount;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}
