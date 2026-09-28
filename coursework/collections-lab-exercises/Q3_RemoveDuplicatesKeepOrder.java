/*
 * Exercise 3: Given a list with duplicates, produce a list of unique
 * values preserving insertion order.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Q3_RemoveDuplicatesKeepOrder {
    public static void main(String[] args) {
        List<Integer> withDuplicates = Arrays.asList(4, 2, 7, 2, 9, 4, 1, 7, 3);

        Set<Integer> seen = new LinkedHashSet<>(withDuplicates);
        List<Integer> unique = new ArrayList<>(seen);

        System.out.println("Original list: " + withDuplicates);
        System.out.println("Unique values (insertion order kept): " + unique);
    }
}
