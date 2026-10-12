/*
 * LeetCode #1929 — Concatenation of Array
 * https://leetcode.com/problems/concatenation-of-array/
 *
 * Problem: Given an array nums of length n, return an array of length 2n
 * where ans[i] == nums[i] and ans[i + n] == nums[i].
 *
 * Concept link: A for-loop fits best — the output length (2 * nums.length)
 * is known exactly upfront, and each source index maps directly to two
 * fixed output indices.
 *
 * Time: O(n)    Space: O(n) (output array)
 */
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[i];
            result[i + n] = nums[i];
        }
        return result;
    }
}

public class Q5_ConcatenationOfArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 1};
        System.out.println("Input:  " + java.util.Arrays.toString(nums));
        System.out.println("Output: " + java.util.Arrays.toString(sol.getConcatenation(nums)));
    }
}
