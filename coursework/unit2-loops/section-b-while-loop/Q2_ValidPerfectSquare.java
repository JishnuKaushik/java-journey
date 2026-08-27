/*
 * LeetCode #367 — Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/
 *
 * Problem: Given a positive integer num, return true if it is a perfect
 * square, without using any built-in library function.
 *
 * Concept link: A while-loop fits best — binary search terminates the
 * instant the shrinking search window resolves the answer, not after a
 * fixed count of steps.
 *
 * Time: O(log num)    Space: O(1)
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}

public class Q2_ValidPerfectSquare {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num = 16;
        System.out.println("Input: num = " + num);
        System.out.println("Output: " + sol.isPerfectSquare(num));
    }
}
