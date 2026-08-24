/*
 * LeetCode #20 — Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Problem: Given a string containing only the characters (){}[], determine
 * if the brackets are validly matched and nested.
 *
 * Concept link: Branching decides three separate things per character:
 * whether to push (opening bracket) or check-and-pop (closing bracket), and
 * — nested inside that else — which of three mismatch conditions applies. A
 * good example of if-else driving control flow around a data structure (a
 * stack) rather than just producing a value.
 *
 * Time: O(n)    Space: O(n)
 */
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;             // closing bracket with nothing open
                }
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}

public class Q2_ValidParentheses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("()[]{}"));  // true
        System.out.println(sol.isValid("(]"));      // false
    }
}
