/*
 * LeetCode #461 — Hamming Distance
 * https://leetcode.com/problems/hamming-distance/
 *
 * Problem: Given two integers x and y, return the number of positions at
 * which their binary representations differ.
 *
 * Concept link: Chains three operators together: XOR (^) to mark every
 * differing bit as 1 in one shot, then AND (&) with 1 and right shift (>>) in
 * a loop to count those marked bits — a direct combination of the bitwise
 * operators covered earlier, used for something an if-else chain could not
 * do as cleanly.
 *
 * Time: O(1) — bounded by 32 bits    Space: O(1)
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int xorResult = x ^ y;   // 1 wherever x and y differ
        int count = 0;
        while (xorResult != 0) {
            count += xorResult & 1;
            xorResult >>= 1;
        }
        return count;
    }
}

public class Q2_HammingDistance {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.hammingDistance(1, 4));  // 2
        System.out.println(sol.hammingDistance(3, 1));  // 1
    }
}
