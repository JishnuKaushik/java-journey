/*
 * LeetCode #136 — Single Number
 * https://leetcode.com/problems/single-number/
 *
 * Problem: Given a non-empty array where every element appears twice except
 * for one, find the element that appears only once. Must run in linear time
 * using O(1) extra space.
 *
 * Concept link: This is the canonical real use of the XOR (^) operator:
 * a ^ a = 0 and a ^ 0 = a, so XOR-ing every element together cancels every
 * pair and leaves only the single unpaired value. A much stronger example
 * than a toy 'a^b' demo.
 *
 * Time: O(n)    Space: O(1)
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;   // pairs cancel out to 0, the odd one survives
        }
        return result;
    }
}

public class Q1_SingleNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.singleNumber(new int[]{2, 2, 1}));        // 1
        System.out.println(sol.singleNumber(new int[]{4, 1, 2, 1, 2}));  // 4
    }
}
