/*
 * LeetCode #15 — 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * Problem: Given an array of integers, return all unique triplets that
 * sum to zero.
 *
 * Concept link: Nested loops fit best — the standard solution sorts the
 * array, then uses an outer loop to fix one number and an inner
 * two-pointer sweep to find the other two, a loop-within-a-loop that
 * avoids the O(n^3) triple-nested brute force.
 *
 * Time: O(n^2)    Space: O(1) extra (excluding output and sort)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate anchors

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

public class Q5_ThreeSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + sol.threeSum(nums));
    }
}
