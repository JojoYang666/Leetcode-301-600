package leetcode_301To600;

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
public class _413_ArithmeticSlices {
    /**
     * Example:

     A = [1, 2, 3, 4]

     return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.

     数组	   等差数列的数目	    与上一数组的等差数列数目比较
     1 2 3	         1	            1 - 0 = 1
     1 2 3 4	     3	            3 - 1 = 2
     1 2 3 4 5	     6	            6 - 3 = 3
     1 2 3 4 5 6	10	            10 - 6 = 4
     1 2 3 4 5 6 7	15	            15 - 10 = 5

     time : O(n)
     space : O(1)

     * @param A
     * @return
     */

    public int numberOfArithmeticSlices(int[] A) {
        int cur = 0, res = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur++;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }
}
