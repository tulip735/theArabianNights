import java.util.*;

public class FindCenter {



    /**
     在二维平面上有 k（0~k-1） 个点，请找出这 k 个点中离质心最近点的编号。质心：横纵坐标为所有点的均值。
     
     示例：
     输入：["1,1", "2,2", "1,2", "1,3"]
     输出：2
    */


    public static int findCenter(String[] points) {
        
        int n = points.length;
        int[][] nums = new int[n][2]; 

        for (int i = 0; i < n; i++) {
            nums[i][0] = Integer.parseInt(points[i].split(",")[0]);
            nums[i][1] = Integer.parseInt(points[i].split(",")[1]);
            // System.out.println(nums[i][0]);
        }

        double[] center = new double[]{0.0,0.0};
        for (int i = 0; i < n; i++) {
            center[0] += ((double) nums[i][0]) / n;
            center[1] += ((double) nums[i][1]) / n;
            System.out.println(center[0]);
            
        }

        double bias = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < n; i++) {
            double x = nums[i][0] - center[0];
            double y = nums[i][1] - center[1];
            // double tmp = Math.sqrt( x * x + y * y );
            double tmp = x * x + y * y;
            if (tmp < bias) {
                bias = tmp;
                index = i;
            }
        }
        return index;

    }


    public static void main(String[] args) {
        
        String[] points = new String[] {"1,1", "2,2", "1,2", "1,3"};
        int res = findCenter(points);
        System.out.println(res);

    }


}
