// https://leetcode.com/problems/rotate-image/
// Time complexity = O(n^2)
// Space complexity = O(1)
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int n = matrix.length;

        // transpose
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                swap(matrix, i, j);
            }
        }

        //reverse each row
        for (int i=0; i<n; i++) {
            reverse(matrix[i]);
        }
    }
    private void reverse (int[] arr) {
        int i=0, j = arr.length-1;
        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}