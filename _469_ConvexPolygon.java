package leetcode_301To600;

import java.util.List;

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
public class _469_ConvexPolygon {

    /**
     * time : O(n)
     * space : O(1)
     * @param points
     * @return
     */
    public boolean isConvex(List<List<Integer>> points) {
        int size = points.size();
        int flag = 0;
        for (int i = 0; i < points.size(); i++) {
            int ori = helper(points.get(i % size), points.get((i + 1) % size), points.get((i + 2) % size));
            if (ori == 0) {
                continue;
            }
            if (flag == 0) {
                flag = ori;
            } else {
                if (flag != ori) {
                    return false;
                }
            }
        }
        return true;
    }

    public int helper(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
        int val = (p3.get(0) - p2.get(0)) * (p2.get(1) - p1.get(1)) -
                 (p2.get(0) - p1.get(0)) * (p3.get(1) - p2.get(1));
        if (val < 0) {
            return 2;
        } else if (val == 0) {
            return 0;
        }
        return 1;
    }
}
