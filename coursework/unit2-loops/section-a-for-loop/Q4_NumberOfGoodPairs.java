/*
 * LeetCode #1512 — Number of Good Pairs
 * https://leetcode.com/problems/number-of-good-pairs/
 *
 * Problem: Given an array of integers, return the number of pairs
 * (i, j) with nums[i] == nums[j] and i < j.
 *
 * Concept link: A for-loop fits best — a single pass with a running
 * frequency map counts pairs in one bounded sweep, avoiding the
 * brute-force nested-loop scan over every (i, j) combination.
 *
 * Time: O(n)    Space: O(n)
 */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = freq.getOrDefault(nums[i], 0);
            pairs += count;
            freq.put(nums[i], count + 1);
        }
        return pairs;
    }
}

public class Q4_NumberOfGoodPairs {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println("Input: " + java.util.Arrays.toString(nums));
        System.out.println("Output: " + sol.numIdenticalPairs(nums));
    }
}
