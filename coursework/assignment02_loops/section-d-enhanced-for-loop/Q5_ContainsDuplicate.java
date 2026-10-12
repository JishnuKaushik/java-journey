/*
 * LeetCode #217 — Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Problem: Given an array of integers, return true if any value appears
 * at least twice.
 *
 * Concept link: An enhanced for-loop fits best — this is a pure
 * membership check against a running set; every element only needs to be
 * inspected by value, and no index is ever consulted.
 *
 * Time: O(n)    Space: O(n)
 */
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}

public class Q5_ContainsDuplicate {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 1};
        System.out.println("Input: " + java.util.Arrays.toString(nums));
        System.out.println("Output: " + sol.containsDuplicate(nums));
    }
}
