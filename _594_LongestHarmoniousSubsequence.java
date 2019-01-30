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
public class _594_LongestHarmoniousSubsequence {

    /**
     * We define a harmonious array is an array where the difference between its maximum value
     * and its minimum value is exactly 1.

     Now, given an integer array, you need to find the length of its longest harmonious subsequence among
     all its possible subsequences.

     Example 1:

     Input: [1,3,2,2,5,2,3,7]
     Output: 5
     Explanation: The longest harmonious subsequence is [3,2,2,2,3].

     time : O(n)
     space : O(n)

     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            if (key < Integer.MAX_VALUE && map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }
}
