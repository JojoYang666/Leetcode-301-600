package leetcode_1To300;

import java.util.HashSet;

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
public class _356_LineReflection {
    /**
     * 356. Line Reflection
     * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

     Example 1:
     Given points = [[1,1],[-1,1]], return true.

     Example 2:
     Given points = [[1,1],[-1,-1]], return false.

     x1 + x2 = c
     min max

     x1 = c - x2

     平行于y轴 : x : 对称 (两个点)
                y : 相同

     HashSet
     1, 找出关于哪个轴对称
     2, check

     "1,1" "-1,1"

     x2 = sum - pair

     time : O(n)
     space : O(n)

     * @param points
     * @return
     */
    public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] pair : points) {
            set.add(pair[0] + "," + pair[1]);
            min = Math.min(min, pair[0]);
            max = Math.max(max, pair[0]);
        }
        int sum = min + max;
        for (int[] pair : points) {
            if (!set.contains(sum - pair[0] + "," + pair[1])) {
                return false;
            }
        }
        return true;
    }
}
