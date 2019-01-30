package leetcode_301To600;

import java.util.*;

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
public class _587_ErecttheFence {

    /**
     * time : O(nlogn)
     * space : O(n)
     * @param points
     * @return
     */
    public List< Point > outerTrees(Point[] points) {
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x == 0 ? o1.y - o2.y : o1.x - o2.x;
            }
        });
        Stack<Point> stack = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            while (stack.size() >= 2 && orientation(points[i],
                    stack.get(stack.size() - 2), stack.get(stack.size() - 1)) > 0) {
                stack.pop();
            }
            stack.push(points[i]);
        }
        stack.pop();
        for (int i = points.length - 1; i >= 0; i--) {
            while (stack.size() >= 2 && orientation(points[i],
                    stack.get(stack.size() - 2), stack.get(stack.size() - 1)) > 0) {
                stack.pop();
            }
            stack.push(points[i]);
        }
        return new ArrayList<>(new HashSet<>(stack));
    }

    private int orientation(Point p1, Point p2, Point p3) {
        return (p3.x - p2.x) * (p2.y - p1.y) - (p2.x - p1.x) * (p3.y - p2.y);
    }

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
}
