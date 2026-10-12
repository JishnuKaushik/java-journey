/*
 * LeetCode #36 — Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Problem: Determine if a 9x9 Sudoku board is valid — each row, column,
 * and 3x3 sub-box must contain digits 1-9 without repetition (only the
 * filled cells need to be validated).
 *
 * Concept link: Nested loops fit best — a 2D grid needs a row index and a
 * column index simultaneously to identify both a cell's position and
 * which row/column/box set it belongs to; that's exactly what an outer
 * loop over rows and an inner loop over columns give you.
 *
 * Time: O(1) (fixed 9x9 board)    Space: O(1) (fixed-size tracking sets)
 */
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char value = board[row][col];
                if (value == '.') continue;
                int box = (row / 3) * 3 + (col / 3);
                if (!seen.add("row" + row + "-" + value)
                        || !seen.add("col" + col + "-" + value)
                        || !seen.add("box" + box + "-" + value)) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Q2_ValidSudoku {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("Input: standard valid 9x9 Sudoku board");
        System.out.println("Output: " + sol.isValidSudoku(board));
    }
}
