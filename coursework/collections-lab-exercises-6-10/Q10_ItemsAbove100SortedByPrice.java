/*
 * Exercise 10: Given a HashMap of item -> price, print items whose
 * price > 100, sorted by price.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q10_ItemsAbove100SortedByPrice {
    public static void main(String[] args) {
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Pen", 20);
        prices.put("Notebook", 60);
        prices.put("Headphones", 1500);
        prices.put("Backpack", 899);
        prices.put("Water Bottle", 250);
        prices.put("Mouse", 450);
        prices.put("Eraser", 5);
        prices.put("Calculator", 120);

        List<Map.Entry<String, Integer>> expensive = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : prices.entrySet()) {
            if (entry.getValue() > 100) {
                expensive.add(entry);
            }
        }

        expensive.sort(Map.Entry.comparingByValue());

        System.out.println("Items with price > 100 (sorted by price):");
        for (Map.Entry<String, Integer> entry : expensive) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Same thing with Streams (Java 8+):
        // prices.entrySet().stream()
        //         .filter(e -> e.getValue() > 100)
        //         .sorted(Map.Entry.comparingByValue())
        //         .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
