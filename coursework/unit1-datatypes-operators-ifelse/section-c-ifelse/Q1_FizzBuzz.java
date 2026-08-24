/*
 * LeetCode #412 — Fizz Buzz
 * https://leetcode.com/problems/fizz-buzz/
 *
 * Problem: For every integer from 1 to n, output 'Fizz' if divisible by 3,
 * 'Buzz' if divisible by 5, 'FizzBuzz' if divisible by both, and the number
 * itself otherwise.
 *
 * Concept link: The textbook if-else-if ladder, except the order matters for
 * correctness: the divisible-by-15 check must come first, otherwise it would
 * be caught (wrongly) by the divisible-by-3 branch before ever reaching the
 * FizzBuzz case.
 *
 * Time: O(n)    Space: O(1) excluding output
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}

public class Q1_FizzBuzz {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.fizzBuzz(15));
        // [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
    }
}
