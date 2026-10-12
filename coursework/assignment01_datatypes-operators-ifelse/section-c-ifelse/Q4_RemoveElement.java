/*
 * LeetCode #27 — Remove Element
 * https://leetcode.com/problems/remove-element/
 *
 * Problem: Given an integer array and a value val, remove every occurrence
 * of val in place and return the new length.
 *
 * Concept link: A single if condition gates whether an element is kept —
 * everything else (the two-pointer overwrite) hinges on that one branch.
 * Shows if-else being used for in-place array compaction rather than a
 * report/decision output.
 *
 * Time: O(n)    Space: O(1)
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

public class Q4_RemoveElement {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 2, 2, 3};
        int k = sol.removeElement(nums, 3);
        System.out.println("New length: " + k);  // 2
    }
}
