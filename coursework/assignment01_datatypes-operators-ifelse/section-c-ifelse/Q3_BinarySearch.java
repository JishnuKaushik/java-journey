/*
 * LeetCode #704 — Binary Search
 * https://leetcode.com/problems/binary-search/
 *
 * Problem: Given a sorted array of integers and a target value, return the
 * index of the target, or -1 if it isn't present.
 *
 * Concept link: The entire algorithm IS a 3-way if-else-if: equal, less
 * than, or greater than target decide whether to stop or which half to
 * discard. Shows if-else used to control a loop's search space rather than
 * just print a message.
 *
 * Time: O(log n)    Space: O(1)
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;   // avoids int overflow vs (left+right)/2
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

public class Q3_BinarySearch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));  // 4
        System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));  // -1
    }
}
