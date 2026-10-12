/*
 * LeetCode #728 — Self Dividing Numbers
 * https://leetcode.com/problems/self-dividing-numbers/
 *
 * Problem: Given a range [left, right], return every number in that range
 * where each of its own digits divides it evenly, with no digit being zero.
 *
 * Concept link: The result is a List<Integer> — every int added via
 * result.add(num) is autoboxed automatically. It also reinforces safe int
 * division: the digit == 0 check must come before num % digit, otherwise it
 * would throw ArithmeticException (divide by zero).
 *
 * Time: O((right-left) * log(right))    Space: O(1) excluding output
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();   // autoboxing happens on every add()
        for (int num = left; num <= right; num++) {
            if (isSelfDividing(num)) {
                result.add(num);
            }
        }
        return result;
    }

    private boolean isSelfDividing(int num) {
        int n = num;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 0 || num % digit != 0) {   // zero-check must come first
                return false;
            }
            n /= 10;
        }
        return true;
    }
}

public class Q4_SelfDividingNumbers {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.selfDividingNumbers(1, 22));
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
    }
}
