/*
 * LeetCode #54 — Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Problem: Given an m x n matrix, return all elements in spiral order.
 *
 * Concept link: Nested loops fit best — walking a shrinking rectangular
 * boundary (top row, right column, bottom row, left column) is inherently
 * a loop-within-a-loop: an outer pass per boundary layer, inner loops
 * that walk each of its four edges.
 *
 * Time: O(m * n)    Space: O(1) extra (excluding output)
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }
        return result;
    }
}

public class Q1_SpiralMatrix {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Input: [[1,2,3],[4,5,6],[7,8,9]]");
        System.out.println("Output: " + sol.spiralOrder(matrix));
    }
}
