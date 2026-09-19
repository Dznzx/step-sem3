/*
 * Week 2 Assignment - Problem 2: Word Reversal Encoder
 * Reverses each word of a sentence individually while keeping word order,
 * using split(), StringBuilder, and a loop.
 */
public class Homework2_WordReversalEncoder {

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }

    private static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(reverseWord(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    private static String reverseWord(String word) {
        StringBuilder reversed = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed.append(word.charAt(i));
        }
        return reversed.toString();
    }
}
