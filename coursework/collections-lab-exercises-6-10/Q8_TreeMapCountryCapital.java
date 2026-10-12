/*
 * Exercise 8: Create a TreeMap of country -> capital and print all
 * entries (auto-sorted by key).
 */
import java.util.Map;
import java.util.TreeMap;

public class Q8_TreeMapCountryCapital {
    public static void main(String[] args) {
        Map<String, String> capitals = new TreeMap<>();

        // Inserted in random order; TreeMap keeps keys sorted.
        capitals.put("Japan", "Tokyo");
        capitals.put("India", "New Delhi");
        capitals.put("France", "Paris");
        capitals.put("Brazil", "Brasilia");
        capitals.put("Canada", "Ottawa");
        capitals.put("Australia", "Canberra");

        System.out.println("Countries and capitals (sorted by country):");
        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
