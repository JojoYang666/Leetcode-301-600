package leetcode_301To600;

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
public class _436_FindRightInterval {

    /**
     * Given a set of intervals, for each of the interval i,
     * check if there exists an interval j whose start point is bigger than or
     * equal to the end point of the interval i, which can be called that j is on the "right" of i.

     For any interval i, you need to store the minimum interval j's index,
     which means that the interval j has the minimum start point to build the "right" relationship
     for interval i. If the interval j doesn't exist, store -1 for the interval i.
     Finally, you need output the stored value of each interval as an array.

     Note:

     You may assume the interval's end point is always bigger than its start point.
     You may assume none of these intervals have the same start point.
     Example 1:

     Input: [ [1,2] ]

     Output: [-1]

     Explanation: There is only one interval in the collection, so it outputs -1.
     Example 2:

     Input: [ [3,4], [2,3], [1,2] ]

     Output: [-1, 0, 1]

     Explanation: There is no satisfied "right" interval for [3,4].
     For [2,3], the interval [3,4] has minimum-"right" start point;
     For [1,2], the interval [2,3] has minimum-"right" start point.
     Example 3:

     Input: [ [1,4], [2,3], [3,4] ]

     Output: [-1, 2, -1]

     Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
     For [2,3], the interval [3,4] has minimum-"right" start point.


     time : O(nlogn)
     space : O(n)

     * @param intervals
     * @return
     */
    public int[] findRightInterval(Interval[] intervals) {

        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i].end);
            res[i] = key != null ? map.get(key) : -1;
        }

        return res;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
