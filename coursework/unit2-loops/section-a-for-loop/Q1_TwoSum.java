/*
 * LeetCode #1 — Two Sum
 * https://leetcode.com/problems/two-sum/
 *
 * Problem: Given an array of integers and a target, return the indices of
 * the two numbers that add up to the target.
 *
 * Concept link: A for-loop fits best — the array length is known upfront,
 * and the running index is needed both to look back at what's already been
 * seen (via the map) and to record into the answer.
 *
 * Time: O(n)    Space: O(n)
 */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

public class Q1_TwoSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = sol.twoSum(nums, target);
        System.out.println("Input: nums = [2, 7, 11, 15], target = 9");
        System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
    }
}
