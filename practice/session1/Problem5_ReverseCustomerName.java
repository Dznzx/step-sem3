/*
 * Day 1 - Problem 5: Reverse Customer Name
 * Returns a reversed copy of a customer name without modifying the
 * original string.
 */
public class Problem5_ReverseCustomerName {

    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }

    private static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();
        StringBuilder reversed = new StringBuilder();
        for (int i = characters.length - 1; i >= 0; i--) {
            reversed.append(characters[i]);
        }
        return reversed.toString();
    }
}
