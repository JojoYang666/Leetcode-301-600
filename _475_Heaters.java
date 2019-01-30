package leetcode_301To600;

import java.util.Arrays;
import java.util.TreeSet;

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
public class _475_Heaters {

    /**
     * Example 1:

     Input: [1,2,3],[2]
     Output: 1
     Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard,
     then all the houses can be warmed.
     Example 2:

     Input: [1,2,3,4],[1,4]
     Output: 1
     Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard,
     then all the houses can be warmed.

     time : O(nlogn)
     space : O(1)

     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);

        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1
                    && Math.abs(heaters[i + 1] - house) <= Math.abs(heaters[i] - house)) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }

    public int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }

    public int findRadius3(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int heater : heaters) {
            set.add(heater);
        }
        int index = 0, res = 0;
        for (int house : houses) {
            int dist1 = set.ceiling(house) == null ? Integer.MAX_VALUE : set.ceiling(house) - house;
            int dist2 = set.floor(house) == null ? Integer.MAX_VALUE : house - set.floor(house);
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
}
