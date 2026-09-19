/*
 * Week 2 Assignment - Problem 5: Stop-Word-Filtered Word Frequency Report
 * Cleans feedback text, filters out a fixed stop-word list, counts
 * remaining word frequencies, and prints them sorted by count descending.
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Homework5_StopWordFilteredWordFrequencyReport {

    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }

    private static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(",", "").replace(".", "");
        String[] words = cleaned.split("\\s+");

        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : words) {
            if (STOP_WORDS.contains(word)) {
                continue;
            }
            frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencies.entrySet());
        entries.sort(Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue).reversed());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
