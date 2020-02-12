import java.util.*;

class SetMatrixZeros {
    /**
      Given a m x n matrix, 
      if an element is 0, set its entire row and column to 0. Do it in-place.
      Input: 
      [
        [0,1,2,0],
        [3,4,5,2],
        [1,3,1,5]
      ]
      Output: 
      [
        [0,0,0,0],
        [0,4,5,0],
        [0,3,1,0]
      ]
      Follow up:
      A straight forward solution using O(mn) space is probably a bad idea.
      A simple improvement uses O(m + n) space, but still not the best solution.
      Could you devise a constant space solution?
    */
    public static void setZeros(int[][] matrix) {

        final int m = matrix.length;
        final int n = matrix[0].length;

        boolean row = false;
        boolean col = false;

        // 利用第0行和第0列存储后续为0的坐标,先判断0行，0列是否有0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                row = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println(i);
                    System.out.println(j);
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 如果原来0行或0列有0，不会影响，都会遍历到
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeros(matrix);
        final int m = matrix.length;
        final int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matrix[i]));
            // for (int j = 1; j < n; i++) {
            //     System.out.print(matrix[i][j]);
            // }
        }


    }
}
