package leetcode_301To600;

import java.util.ArrayList;
import java.util.Collections;
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
public class _539_MinimumTimeDifference {

    /**
     * Given a list of 24-hour clock time points in "Hour:Minutes" format,
     * find the minimum minutes difference between any two time points in the list.
     Example 1:

     Input: ["23:59","00:00"]
     Output: 1

     time : O(24 * 60)
     space : O(24 * 60)
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time .split(":");
            int hour = Integer.parseInt(t[0]);
            int minute = Integer.parseInt(t[1]);
            if (mark[hour * 60 + minute]) {
                return 0;
            }
            mark[hour * 60 + minute] = true;
        }
        int res = Integer.MAX_VALUE;
        int pre = -1;
        int first = -1;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i]) {
                if (first == -1) {
                    first = i;
                } else {
                    Math.min(res, i - pre);
                }
                pre = i;
            }
        }
        res = Math.min(res, (first + 24 * 60 - pre));
        return res;
    }

    public int findMinDifference2(List<String> timePoints) {
        List<Time> times = new ArrayList<>();
        for (String time : timePoints) {
            String[] strs = time.split(":");
            times.add(new Time(Integer.parseInt(strs[0]), Integer.parseInt(strs[1])));
        }
        Collections.sort(times);
        Time first = times.get(0);
        times.add(new Time(first.hour + 24, first.minute));
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            int diff = Math.abs(times.get(i).getDiff(times.get(i + 1)));
            res = Math.min(res, diff);
        }
        return res;
    }

    class Time implements Comparable<Time> {
        int hour;
        int minute;
        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public int compareTo(Time other) {
            if (this.hour == other.hour) {
                return this.minute - other.minute;
            }
            return this.hour - other.hour;
        }

        public int getDiff(Time other) {
            return (this.hour - other.hour) * 60 + (this.minute - other.minute);
        }
    }
}
