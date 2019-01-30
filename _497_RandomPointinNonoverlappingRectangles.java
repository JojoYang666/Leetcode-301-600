package leetcode_301To600;

import java.util.Random;
import java.util.TreeMap;

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
public class _497_RandomPointinNonoverlappingRectangles {

    /**
     * Given a list of non-overlapping axis-aligned rectangles rects,
     * write a function pick which randomly and uniformily picks an integer point in the space covered
     * by the rectangles.

     Note:

     An integer point is a point that has integer coordinates.
     A point on the perimeter of a rectangle is included in the space covered by the rectangles.
     ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner,
     and [x2, y2] are the integer coordinates of the top-right corner.
     length and width of each rectangle does not exceed 2000.
     1 <= rects.length <= 100
     pick return a point as an array of integer coordinates [p_x, p_y]
     pick is called at most 10000 times.


     Note:

     An integer point is a point that has integer coordinates.
     A point on the perimeter of a rectangle is included in the space covered by the rectangles.
     ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner,
     and [x2, y2] are the integer coordinates of the top-right corner.
     length and width of each rectangle does not exceed 2000.
     1 <= rects.length <= 100
     pick return a point as an array of integer coordinates [p_x, p_y]
     pick is called at most 10000 times.


     time : O(logn)
     space : O(m * n)
     */

    TreeMap<Integer, Integer> map;
    int[][] rects;
    Random random;
    int area;

    public _497_RandomPointinNonoverlappingRectangles(int[][] rects) {
        this.rects = rects;
        map = new TreeMap<>();
        random = new Random();
        area = 0;

        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            area += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(area, i);
        }
    }

    public int[] pick() {
        int rmd = map.ceilingKey(random.nextInt(area) + 1);
        int[] rect = rects[map.get(rmd)];
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);
        return new int[]{x, y};
    }
}
