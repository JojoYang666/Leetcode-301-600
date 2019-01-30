package leetcode_301To600;

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
public class _581_ShortestUnsortedContinuousSubarray {
    /**
     * Given an integer array, you need to find one continuous subarray
     * that if you only sort this subarray in ascending order,
     * then the whole array will be sorted in ascending order, too.

     You need to find the shortest such subarray and output its length.

     Example 1:

     Input: [2, 6, 4, 8, 10, 9, 15]
     Output: 5
     Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.


     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int start = -1;
        int end = -1;
        int min = nums[len - 1], max = nums[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - 1 - i]);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[len - 1 - i] > min) {
                start = len - 1 - i;
            }
        }
        return end - start + 1;
    }
}
