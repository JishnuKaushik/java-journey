/*
 * LeetCode #35 — Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 *
 * Problem: Given a sorted array of distinct integers and a target, return
 * the index if found, or the index where it would be inserted in order.
 *
 * Concept link: A while-loop fits best — binary search's stopping point
 * (lo crossing hi) depends on the data being searched, not on a count
 * known in advance.
 *
 * Time: O(log n)    Space: O(1)
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}

public class Q3_SearchInsertPosition {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums) + ", target = " + target);
        System.out.println("Output: " + sol.searchInsert(nums, target));
    }
}
