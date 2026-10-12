/*
 * LeetCode #69 — Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 *
 * Problem: Given a non-negative integer x, return the square root of x
 * rounded down to the nearest integer, without using any built-in
 * exponent/sqrt function.
 *
 * Concept link: A while-loop fits best — binary search stops the moment
 * the search window closes, an outcome that depends on x rather than a
 * fixed number of steps known in advance.
 *
 * Time: O(log x)    Space: O(1)
 */
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        long lo = 1, hi = x / 2;
        long ans = 1;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long square = mid * mid;
            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int) ans;
    }
}

public class Q1_SqrtX {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int x = 8;
        System.out.println("Input: x = " + x);
        System.out.println("Output: " + sol.mySqrt(x));
    }
}
