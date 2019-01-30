package leetcode_301To600;

import java.util.HashMap;
import java.util.Map;

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
public class _532_KdiffPairsinanArray {

    /**
     * Given an array of integers and an integer k, you need to find the number
     * of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j),
     * where i and j are both numbers in the array and their absolute difference is k.

     Example 1:

     Input: [3, 1, 4, 1, 5], k = 2
     Output: 2
     Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
     Although we have two 1s in the input, we should only return the number of unique pairs.
     Example 2:

     Input:[1, 2, 3, 4, 5], k = 1
     Output: 4
     Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
     Example 3:

     Input: [1, 3, 1, 5, 4], k = 0
     Output: 1
     Explanation: There is one 0-diff pair in the array, (1, 1).

     time : O(n)
     space : O(n)

     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    res++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    res++;
                }
            }
        }
        return res;
    }
}
