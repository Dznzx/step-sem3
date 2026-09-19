/*
 * Category C Assignment - Problem 2: Duplicate Player Pick Checker
 * Nested-loop scan (no Collections) reporting the first duplicate found,
 * comparing each name only against names that come after it.
 */
public class Homework2_DuplicatePlayerPickChecker {

    public static void main(String[] args) {
        System.out.println(findDuplicatePick(new String[] {"Kohli", "Bumrah", "Kohli", "Rohit"}));
        System.out.println(findDuplicatePick(new String[] {"Kohli", "Bumrah", "Rohit"}));
    }

    private static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }
}
