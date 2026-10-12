/*
 * LeetCode #191 — Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * Problem: Given a 32-bit integer, count how many bits in its binary
 * representation are set to 1 (also called the Hamming weight).
 *
 * Concept link: This makes the earlier '4 bytes = 32 bits' fact about int
 * concrete: the number is treated as a raw bit pattern, not a signed value.
 * The solution uses the unsigned right shift (>>>) instead of (>>), because a
 * negative int's sign bit would otherwise get copied forward by >> and
 * corrupt the bit count — the same signed-vs-unsigned nuance flagged for char
 * earlier.
 *
 * Time: O(1) — fixed 32 iterations    Space: O(1)
 */
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;   // unsigned shift — no sign-bit copying
        }
        return count;
    }
}

public class Q5_NumberOf1Bits {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.hammingWeight(11));          // 3 (00000000000000000000000000001011)
        System.out.println(sol.hammingWeight(128));         // 1
        System.out.println(sol.hammingWeight(-3));          // 31
    }
}
