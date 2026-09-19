/*
 * Week 2 Assignment - Problem 4: Library ISBN Normalizer & Validator
 * Normalizes a raw ISBN-style code (trim + uppercase publisher code), then
 * validates its 3-letter/4-digit/6-digit structure without regex.
 */
public class Homework4_LibraryIsbnNormalizerValidator {

    public static void main(String[] args) {
        runAndReport(" pen2026004251 ");
        runAndReport("12N2026004251");
    }

    private static void runAndReport(String raw) {
        String normalized = normalizeCode(raw);
        System.out.println(validateAndFormat(normalized));
    }

    private static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);
        return publisherCode + remainder;
    }

    private static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, 3);
        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = code.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining 10 characters must be digits";
            }
        }

        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7, 13);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(publisherCode).append("] YEAR: ")
                .append(year).append(" | CATALOG: ").append(catalogNumber);
        return formatted.toString();
    }
}
