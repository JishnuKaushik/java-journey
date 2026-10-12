/*
 * LeetCode #292 — Nim Game
 * https://leetcode.com/problems/nim-game/
 *
 * Problem: In a game where two players alternately remove 1-3 stones from a
 * pile of n stones (whoever takes the last stone wins), determine if the
 * first player can guarantee a win.
 *
 * Concept link: Reduces an entire game-theory problem to one modulo (%) and
 * one relational (!=) operator — the first player loses only if n is an
 * exact multiple of 4, since the opponent can always mirror moves back to the
 * next multiple of 4. A clean example of precedence: % binds tighter than
 * !=, so n % 4 != 0 evaluates as (n % 4) != 0.
 *
 * Time: O(1)    Space: O(1)
 */
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}

public class Q5_NimGame {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canWinNim(4));  // false
        System.out.println(sol.canWinNim(1));  // true
    }
}
