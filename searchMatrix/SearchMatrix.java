import java.util.*;


class SearchMatrix {

    /**
      Write an efficient algorithm that searches for a value in an m x n matrix. 
      This matrix has the following properties:
      1.Integers in each row are sorted in ascending from left to right.
      2.Integers in each column are sorted in ascending from top to bottom.

      Example:
      Consider the following matrix:
      [
        [1,   4,  7, 11, 15],
        [2,   5,  8, 12, 19],
        [3,   6,  9, 16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30]
      ]
    */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if(target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,8,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        if (searchMatrix(matrix,18))
            System.out.println("ok");
        
    }
}
