/*
 * Q8. Differentiate between int and Integer in Java. What is autoboxing and
 * unboxing?
 *
 * Ans: int is a primitive type that stores a raw numeric value directly.
 * Integer is a wrapper class that wraps an int value inside an object,
 * giving it object capabilities (e.g. being usable in collections like
 * ArrayList<Integer>, or being null). Autoboxing is Java automatically
 * converting a primitive into its wrapper object (int -> Integer); unboxing
 * is the reverse (Integer -> int). Both happen implicitly at compile time.
 */
public class Q8_IntVsInteger {
    public static void main(String[] args) {
        Integer a = 5;      // autoboxing: int 5 -> Integer object
        int b = a;           // unboxing: Integer object -> int
        // Note: Integer caches values from -128 to 127, so == can behave
        // unexpectedly outside that range for cached vs. new Integer objects.
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
