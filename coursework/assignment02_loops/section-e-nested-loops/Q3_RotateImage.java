/*
 * LeetCode #48 — Rotate Image
 * https://leetcode.com/problems/rotate-image/
 *
 * Problem: Rotate an n x n matrix 90 degrees clockwise, in place.
 *
 * Concept link: Nested loops fit best — both the transpose step and the
 * row-reversal step operate on every (row, column) cell of a 2D grid,
 * which by definition needs two coordinates tracked at once via an outer
 * and inner loop.
 *
 * Time: O(n^2)    Space: O(1)
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for (int row = 0; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // reverse each row
        for (int row = 0; row < n; row++) {
            for (int left = 0, right = n - 1; left < right; left++, right--) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
            }
        }
    }
}

public class Q3_RotateImage {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Input: [[1,2,3],[4,5,6],[7,8,9]]");
        sol.rotate(matrix);
        System.out.println("Output: " + java.util.Arrays.deepToString(matrix));
    }
}
