/*
 * Exercise 1: Create an ArrayList of 5 city names, print it, then remove
 * the 3rd city and print again.
 */
import java.util.ArrayList;
import java.util.List;

public class Q1_CityArrayList {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Chennai");
        cities.add("Kolkata");
        cities.add("Bengaluru");

        System.out.println("Cities: " + cities);

        String removed = cities.remove(2); // 3rd city -> index 2
        System.out.println("Removed 3rd city: " + removed);
        System.out.println("Cities after removal: " + cities);
    }
}
