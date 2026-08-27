/*
 * LeetCode #1281 — Subtract the Product and Sum of Digits of an Integer
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 * Problem: Given an integer n, return the difference between the product
 * of its digits and the sum of its digits.
 *
 * Concept link: An enhanced for-loop fits best — once n's digits are
 * viewed as a char array, we just need to consume each digit character
 * in order to accumulate a running product and sum, with no index needed.
 *
 * Time: O(log n)    Space: O(log n) for the digit string
 */
class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            int digit = c - '0';
            product *= digit;
            sum += digit;
        }
        return product - sum;
    }
}

public class Q4_SubtractProductAndSumOfDigits {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 234;
        System.out.println("Input: n = " + n);
        System.out.println("Output: " + sol.subtractProductAndSum(n));
    }
}
