/*
 * LeetCode #73 — Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Problem: Given an m x n matrix, if an element is 0, set its entire row
 * and column to 0, in place.
 *
 * Concept link: Nested loops fit best — both the scan for zeroes and the
 * pass that zeroes out rows/columns need to visit every (row, column)
 * cell of a 2D grid, which requires two coordinates tracked together.
 *
 * Time: O(m * n)    Space: O(1) (using the first row/column as markers)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean firstRowHasZero = false, firstColHasZero = false;

        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) firstRowHasZero = true;
        }
        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 0) firstColHasZero = true;
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int col = 0; col < cols; col++) matrix[0][col] = 0;
        }
        if (firstColHasZero) {
            for (int row = 0; row < rows; row++) matrix[row][0] = 0;
        }
    }
}

public class Q4_SetMatrixZeroes {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println("Input: [[1,1,1],[1,0,1],[1,1,1]]");
        sol.setZeroes(matrix);
        System.out.println("Output: " + java.util.Arrays.deepToString(matrix));
    }
}
