/*
 * LeetCode #231 — Power of Two
 * https://leetcode.com/problems/power-of-two/
 *
 * Problem: Given an integer n, determine if it is a power of two.
 *
 * Concept link: A single-line expression mixing four operator categories at
 * once: relational (n > 0), bitwise AND (&), arithmetic (n - 1), and logical
 * AND (&&) — a direct real-world test of operator precedence. Powers of two
 * have exactly one set bit, so n & (n-1) clears that single bit and yields 0
 * only for powers of two.
 *
 * Time: O(1)    Space: O(1)
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
        // n > 0            -> relational operator, rules out 0 and negatives
        // (n - 1)          -> arithmetic, evaluated first due to parentheses
        // n & (n - 1)      -> bitwise AND clears the lowest set bit
        // == 0             -> true only if n had exactly one set bit
        // &&               -> both conditions must hold
    }
}

public class Q4_PowerOfTwo {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfTwo(1));   // true
        System.out.println(sol.isPowerOfTwo(16));  // true
        System.out.println(sol.isPowerOfTwo(3));   // false
    }
}
