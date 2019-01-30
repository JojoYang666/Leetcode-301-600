package leetcode_1To300;

import java.util.TreeSet;

/**
 * 本代码来自 Cspiration，由 @Cspiration 提供
 * 题目来源：http://leetcode.com
 * - Cspiration 致力于在 CS 领域内帮助中国人找到工作，让更多海外国人受益
 * - 现有课程：Leetcode Java 版本视频讲解（1-900题）（上）（中）（下）三部
 * - 算法基础知识（上）（下）两部；题型技巧讲解（上）（下）两部
 * - 节省刷题时间，效率提高2-3倍，初学者轻松一天10题，入门者轻松一天20题
 * - 讲师：Edward Shi
 * - 官方网站：https://cspiration.com
 * - 版权所有，转发请注明出处
 */
public class _363_MaxSumofRectangleNoLargerThanK {

    /**
     * 363. Max Sum of Rectangle No Larger Than K
     * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle
     * in the matrix such that its sum is no larger than k.

     Example:
     Given matrix = [
     [1,  0, 1],
     [0, -2, 3]
     ]
     k = 2
     The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

     Note:
     The rectangle inside the matrix must have an area > 0.
     What if the number of rows is much larger than the number of columns?


     1, 求matrix中和最大的那个矩形，返回最大值
     2, 一维 array, 找出其中连续的一段，其和最大，但是不大于 k

     1  0 1 2
     0 -2 3 1
     2  4 1 -2
     3  1 2 -1


     sums = [1 -2 6 4]

     reference: https://www.jianshu.com/p/e9ff87d6bf8e

     time : O[min(m,n)^2 * max(m,n) * log(max(m,n))]
     space : O(max(m, n))

     * @param matrix
     * @param k
     * @return
     */
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;

        for (int left = 0; left < n; left++) {
            int[] sums = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    sums[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int cur = 0;
                for (int sum : sums) {
                    cur += sum;
                    Integer num = set.ceiling(cur - k);
                    if (num != null) {
                        res = Math.max(res, cur - num);
                    }
                    set.add(cur);
                }
            }
        }
        return res;
    }


    private int helper(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer num = set.ceiling(sum - k);
            if (num != null) {
                res = Math.max(res, sum - num);
            }
            set.add(sum);
        }
        return res;
    }

}
