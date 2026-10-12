/*
 * LeetCode #283 — Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 *
 * Problem: Move all zeroes in an array to the end while keeping the
 * relative order of the non-zero elements, in place.
 *
 * Concept link: A for-loop fits best — the traversal length (nums.length)
 * is fixed upfront, and the loop index doubles as the "next write position"
 * for non-zero elements.
 *
 * Time: O(n)    Space: O(1)
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos++] = nums[i];
            }
        }
        for (int i = insertPos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

public class Q2_MoveZeroes {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Input:  " + java.util.Arrays.toString(nums));
        sol.moveZeroes(nums);
        System.out.println("Output: " + java.util.Arrays.toString(nums));
    }
}
