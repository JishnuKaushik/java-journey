/*
 * LeetCode #66 — Plus One
 * https://leetcode.com/problems/plus-one/
 *
 * Problem: Given a large integer represented as an array of digits (most
 * significant digit first), add one to the integer and return the resulting
 * array.
 *
 * Concept link: Models manual carry propagation using the increment operator
 * (++) and a relational check (digits[i] < 9) — the same logic a compound
 * assignment like x += 1 hides inside a single machine instruction, made
 * explicit digit by digit.
 *
 * Time: O(n)    Space: O(1) extra (O(n) only if a new array is needed)
 */
import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;        // no carry needed, done
                return digits;
            }
            digits[i] = 0;          // carry: this digit rolls over to 0
        }
        // every digit was 9 -> array grew by one place, e.g. 999 -> 1000
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}

public class Q3_PlusOne {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.plusOne(new int[]{1, 2, 3})));  // [1, 2, 4]
        System.out.println(Arrays.toString(sol.plusOne(new int[]{9, 9, 9})));  // [1, 0, 0, 0]
    }
}
