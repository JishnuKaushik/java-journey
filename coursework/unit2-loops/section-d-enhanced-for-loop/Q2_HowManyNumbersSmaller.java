/*
 * LeetCode #1365 — How Many Numbers Are Smaller Than the Current Number
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * Problem: For each nums[i], count how many numbers in the array are
 * smaller than it.
 *
 * Concept link: An enhanced for-loop fits best — both passes that touch
 * the input array (building the frequency counts, then reading them back
 * per element) only ever need each element's value, never its index.
 * (The prefix-sum step over the small fixed 0-100 count range is the one
 * exception, since accumulating count[i] += count[i - 1] inherently needs
 * the previous index.)
 *
 * Time: O(n)    Space: O(1) extra (fixed 0-100 count array)
 */
import java.util.Arrays;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }
        int[] result = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            result[i++] = (num == 0) ? 0 : count[num - 1];
        }
        return result;
    }
}

public class Q2_HowManyNumbersSmaller {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {8, 1, 2, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(sol.smallerNumbersThanCurrent(nums)));
    }
}
