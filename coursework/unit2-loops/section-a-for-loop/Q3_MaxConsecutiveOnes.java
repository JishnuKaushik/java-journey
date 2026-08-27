/*
 * LeetCode #485 — Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 *
 * Problem: Given a binary array, return the maximum number of consecutive
 * 1's in the array.
 *
 * Concept link: A for-loop fits best — it's a single bounded sweep over a
 * known-length array with a running streak counter, with no early or
 * variable termination needed.
 *
 * Time: O(n)    Space: O(1)
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
                max = Math.max(max, current);
            } else {
                current = 0;
            }
        }
        return max;
    }
}

public class Q3_MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println("Input: " + java.util.Arrays.toString(nums));
        System.out.println("Output: " + sol.findMaxConsecutiveOnes(nums));
    }
}
