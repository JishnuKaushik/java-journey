/*
 * Exercise 9: Merge two Sets into one (union) and also find their
 * intersection.
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Q9_SetUnionIntersection {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // Copy first so the original sets are not modified.
        Set<Integer> union = new TreeSet<>(setA);
        union.addAll(setB);

        Set<Integer> intersection = new TreeSet<>(setA);
        intersection.retainAll(setB);

        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);
        System.out.println("Union (A or B): " + union);
        System.out.println("Intersection (A and B): " + intersection);
    }
}
