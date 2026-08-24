/*
 * LeetCode #977 — Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Problem: Given an integer array sorted in non-decreasing order, return an
 * array of the squares of each number, also sorted in non-decreasing order.
 *
 * Concept link: Because the array can contain negatives, the largest square
 * can come from either end — an if-else comparison decides which of the two
 * pointers to advance at every step, filling the result array back-to-front.
 * Demonstrates if-else driving a two-pointer merge instead of a simple
 * branch.
 *
 * Time: O(n)    Space: O(n) for output
 */
import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int leftVal = Math.abs(nums[left]);
            int rightVal = Math.abs(nums[right]);
            if (leftVal > rightVal) {
                result[i] = leftVal * leftVal;
                left++;
            } else {
                result[i] = rightVal * rightVal;
                right--;
            }
        }
        return result;
    }
}

public class Q5_SortedSquares {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        // [0, 1, 9, 16, 100]
    }
}
