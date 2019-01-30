package leetcode_1To300;

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
public class _325_MaximumSizeSubarraySumEqualsk {
    /**
     * 325. Maximum Size Subarray Sum Equals k
     * Example 1:
     Given nums = [1, -1, 5, -2, 3], k = 3,
     return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

     Example 2:
     Given nums = [-2, -1, 2, 1], k = 1,
     return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

     [1, -1, 5, -2, 3]  k = 3

     1, 0, 5, 3, 6  k = 3

     time : O(n)
     space : O(n)

     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                res = Math.max(res, i - map.get(nums[i] - k));
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
