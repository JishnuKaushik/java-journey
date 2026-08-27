/*
 * LeetCode #1207 — Unique Number of Occurrences
 * https://leetcode.com/problems/unique-number-of-occurrences/
 *
 * Problem: Given an array of integers, return true if the number of
 * occurrences of each value is unique.
 *
 * Concept link: An enhanced for-loop fits best — both the frequency-count
 * pass over the array and the uniqueness check over the counted values
 * only need each element's value, with no index ever consulted.
 *
 * Time: O(n)    Space: O(n)
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        Set<Integer> seenCounts = new HashSet<>();
        for (int occurrences : count.values()) {
            if (!seenCounts.add(occurrences)) {
                return false;
            }
        }
        return true;
    }
}

public class Q3_UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println("Input: " + java.util.Arrays.toString(arr));
        System.out.println("Output: " + sol.uniqueOccurrences(arr));
    }
}
