package leetcode_301To600;

import java.util.Arrays;
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
public class _593_ValidSquare {

    /**
     * Given the coordinates of four points in 2D space, return whether the four points could construct a square.

     The coordinate (x,y) of a point is represented by an integer array with two integers.

     Example:

     Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
     Output: True

     time : O(1)
     space : O(1)

     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(distance(p1, p2), distance(p1, p3), distance(p1, p4),
                distance(p2, p3), distance(p2, p4), distance(p3, p4)));
        return !set.contains(0) && set.size() == 2;
    }

    private int distance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
