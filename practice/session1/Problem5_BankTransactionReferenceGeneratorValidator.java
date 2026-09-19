/*
 * Day 2 - Problem 5: Bank Transaction Reference Generator & Validator
 * Normalizes a raw transaction reference (trim + uppercase bank code),
 * then validates its 3-letter/6-digit/5-digit structure without regex.
 */
public class Problem5_BankTransactionReferenceGeneratorValidator {

    public static void main(String[] args) {
        runAndReport(" hdf03022600042 ");
        runAndReport("12F03022600042");
    }

    private static void runAndReport(String raw) {
        String normalized = normalizeReference(raw);
        String result = validateAndFormat(normalized);
        System.out.println(result);
    }

    private static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);
        return bankCode + remainder;
    }

    private static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        String bankCode = reference.substring(0, 3);
        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        String body = reference.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining 11 characters must be digits";
            }
        }

        String datePart = reference.substring(3, 9);
        String sequencePart = reference.substring(9, 14);
        String day = datePart.substring(0, 2);
        String month = datePart.substring(2, 4);
        String year = datePart.substring(4, 6);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] DATE: ")
                .append(day).append("/").append(month).append("/").append(year)
                .append(" | SEQ: ").append(sequencePart);
        return formatted.toString();
    }
}
