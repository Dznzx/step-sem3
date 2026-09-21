/*
 * Category C - Problem 4: The Locker Code
 * Write-only combination: no getter exists at all. changeCode verifies
 * the current code first and rejects the change entirely if it's wrong.
 */
public class Problem4_TheLockerCode {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println(l.changeCode("1234", "5678"));
        System.out.println(l.changeCode("0000", "9999"));
    }
}

class Locker {
    private final int lockerNumber;
    private String code;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    String changeCode(String currentCode, String newCode) {
        if (!currentCode.equals(code)) {
            return "rejected, code is still \"" + code + "\"";
        }
        code = newCode;
        return "success";
    }

    int getLockerNumber() {
        return lockerNumber;
    }
}
