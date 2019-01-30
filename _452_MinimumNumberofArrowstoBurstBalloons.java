/*
 * 本代码来自 cspiration
 * 网站地址：cspiration.com
 * 创作人：Edward Shi
 */

package leetcode_301To600;

import java.util.Arrays;

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
public class _452_MinimumNumberofArrowstoBurstBalloons {


    /**
     * There are a number of spherical balloons spread in two-dimensional space. For each balloon,
     * provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal,
     * y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice.
     * Start is always smaller than end. There will be at most 104 balloons.

     An arrow can be shot up exactly vertically from different points along the x-axis.
     A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
     There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely.
     The problem is to find the minimum number of arrows that must be shot to burst all balloons.

     Example:

     Input:
     [[10,16], [2,8], [1,6], [7,12]]

     Output:
     2

     Explanation:
     One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6])
     and another arrow at x = 11 (bursting the other two balloons).

     Leetcode 253

     * time : O(nlogn)
     * space : O(1)
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> (a[0] - b[0]));
        int res = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                res++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        return res;
    }

}
