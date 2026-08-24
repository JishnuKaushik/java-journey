/*
 * LeetCode #258 — Add Digits
 * https://leetcode.com/problems/add-digits/
 *
 * Problem: Given a non-negative integer, repeatedly add its digits until the
 * result has only one digit. Return that digit.
 *
 * Concept link: This is the same digital-root idea from the earlier lab
 * exercise, revisited purely through int arithmetic: repeated modulo (%) and
 * division (/) to peel off digits, with an outer loop controlling when to
 * stop. A neat O(1) alternative also exists using pure int math:
 * return num == 0 ? 0 : 1 + (num - 1) % 9 — no loop at all.
 *
 * Time: O(log n) — or O(1) with the formula    Space: O(1)
 */
class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}

// O(1) alternative (digital root formula):
// return num == 0 ? 0 : 1 + (num - 1) % 9;

public class Q3_AddDigits {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addDigits(38));  // 2
        System.out.println(sol.addDigits(0));   // 0
    }
}
