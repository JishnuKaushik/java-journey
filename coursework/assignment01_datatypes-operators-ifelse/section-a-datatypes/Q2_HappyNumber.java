/*
 * LeetCode #202 — Happy Number
 * https://leetcode.com/problems/happy-number/
 *
 * Problem: Given a positive integer, repeatedly replace it with the sum of
 * the squares of its digits. Return true if this process reaches 1, false if
 * it loops forever.
 *
 * Concept link: Cycle detection needs a HashSet<Integer> — since Java
 * generics can't hold a raw int, every value added or checked is autoboxed
 * from int to Integer (and unboxed back when compared with n == 1). This is
 * the autoboxing/unboxing idea in action, not just a textbook Integer
 * example.
 *
 * Time: O(log n) per iteration, bounded overall by cycle detection    Space: O(log n)
 */
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {   // autoboxing: int -> Integer on insert/lookup
            seen.add(n);
            n = sumOfSquares(n);
        }
        return n == 1;
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}

public class Q2_HappyNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isHappy(19));  // true
        System.out.println(sol.isHappy(2));   // false
    }
}
