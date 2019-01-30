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
public class _447_NumberofBoomerangs {
    /**
     * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k)
     * such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

     Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of
     points are all in the range [-10000, 10000] (inclusive).

     Example:
     Input:
     [[0,0],[1,0],[2,0]]

     Output:
     2

     Explanation:
     The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

     time : O(n^2)
     space : O(n)


     * @param points
     * @return
     */

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            for (int val : map.values()) {
                res += val * (val - 1);
            }
            map.clear();
        }
        return res;
    }

    public int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

}
