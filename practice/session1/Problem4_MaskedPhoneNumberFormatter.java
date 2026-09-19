/*
 * Day 2 - Problem 4: Masked Phone Number Formatter
 * Validates a 10-digit phone number and builds a masked display showing
 * only the last 4 digits, using StringBuilder.
 */
public class Problem4_MaskedPhoneNumberFormatter {

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }

    private static String maskPhoneNumber(String phone) {
        if (phone.length() != 10 || !isAllDigits(phone)) {
            return "Invalid phone number";
        }

        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX");
        masked.append("-");
        masked.append(phone.substring(6));
        return masked.toString();
    }

    private static boolean isAllDigits(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
