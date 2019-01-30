package leetcode_301To600;

import java.util.HashMap;

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
public class _454_FourSumII {
    /**
     * 454. 4Sum II
     * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
     * there are such that A[i] + B[j] + C[k] + D[l] is zero.

     To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
     All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

     Example:

     Input:
     A = [ 1, 2]
     B = [-2,-1]
     C = [-1, 2]
     D = [ 0, 2]

     Output:
     2

     Explanation:
     The two tuples are:
     1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

     time : O(n^2)
     space : O(n)

     space : ON^2???
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                int sum = -c - d;
                res += map.getOrDefault(sum, 0);
            }
        }
        return res;
    }
}
