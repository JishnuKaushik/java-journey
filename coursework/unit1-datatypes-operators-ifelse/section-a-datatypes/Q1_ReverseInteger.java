/*
 * LeetCode #7 — Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 *
 * Problem: Given a 32-bit signed integer, reverse its digits. If the reversed
 * value overflows the 32-bit signed int range, return 0.
 *
 * Concept link: int in Java is fixed at 32 bits (range roughly ±2.1 billion) —
 * reversing digits can easily overflow that range. The solution accumulates
 * the result in a long (a wider type) so it can safely check against
 * Integer.MAX_VALUE/MIN_VALUE before ever narrowing back down to int — a
 * direct, practical use of the widening/narrowing casting rule from the
 * earlier Data Types section.
 *
 * Time: O(log10 x)    Space: O(1)
 */
class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) result;   // narrowing cast back to int, safe by now
    }
}

public class Q1_ReverseInteger {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(123));         // 321
        System.out.println(sol.reverse(-123));        // -321
        System.out.println(sol.reverse(120));         // 21
        System.out.println(sol.reverse(1534236469));  // 0 (overflow)
    }
}
