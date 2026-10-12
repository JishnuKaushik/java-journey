/*
 * LeetCode #1470 — Shuffle the Array
 * https://leetcode.com/problems/shuffle-the-array/
 *
 * Problem: Given nums = [x1,...,xn,y1,...,yn], return the array in the
 * form [x1,y1,x2,y2,...,xn,yn].
 *
 * Concept link: An enhanced for-loop fits best — once the array is split
 * into its two halves, we only need to consume each element of the first
 * half in order; no index arithmetic drives the loop condition itself,
 * only the output placement.
 *
 * Time: O(n)    Space: O(n) (output array)
 */
import java.util.Arrays;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] x = Arrays.copyOfRange(nums, 0, n);
        int[] y = Arrays.copyOfRange(nums, n, 2 * n);
        int[] result = new int[2 * n];
        int yIndex = 0;
        int pos = 0;
        for (int xi : x) {
            result[pos++] = xi;
            result[pos++] = y[yIndex++];
        }
        return result;
    }
}

public class Q1_ShuffleTheArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", n = " + n);
        System.out.println("Output: " + Arrays.toString(sol.shuffle(nums, n)));
    }
}
