/*
 * Day 2 - Problem 2: CSV Student Record Parser
 * Splits a "Name,RollNumber,Department" CSV line into fields and prints
 * a formatted record, or reports an invalid record.
 */
public class Problem2_CsvStudentRecordParser {

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
    }

    private static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Name: " + fields[0] + " | Roll No: " + fields[1] + " | Dept: " + fields[2]);
    }
}
