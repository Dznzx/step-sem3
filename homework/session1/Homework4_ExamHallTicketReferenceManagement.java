/*
 * Category C Assignment - Problem M4: Exam Hall Ticket Reference Management
 * Demonstrates object references: a second variable pointing at the same
 * object shares its state, while an equal-but-separate object is not ==.
 */
public class Homework4_ExamHallTicketReferenceManagement {
    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;
        copy.seatNumber = 45;

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}

class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}
