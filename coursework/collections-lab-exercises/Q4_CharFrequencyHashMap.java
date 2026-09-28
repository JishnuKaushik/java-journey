/*
 * Exercise 4: Use a HashMap to count the frequency of each character in
 * the string "engineering". */
import java.util.HashMap;
import java.util.Map;

public class Q4_CharFrequencyHashMap {
    public static void main(String[] args) {
        String word = "engineering";
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character frequencies in \"" + word + "\":");
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
