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
public class _410_SplitArrayLargestSum {

    /**
     * Given an array which consists of non-negative integers and an integer m,
     * you can split the array into m non-empty continuous subarrays.
     * Write an algorithm to minimize the largest sum among these m subarrays.

     Note:
     If n is the length of array, assume the following constraints are satisfied:

     1 ≤ n ≤ 1000
     1 ≤ m ≤ min(50, n)
     Examples:

     Input:
     nums = [7,2,5,10,8]
     m = 2

     Output:
     18

     Explanation:
     There are four ways to split nums into two subarrays.
     The best way is to split it into [7,2,5] and [10,8],
     where the largest sum among the two subarrays is only 18.

     time : O(nlogn) 级别 sum - max
     space : O(1)

     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) {
            return (int)sum;
        }
        long left = max;
        long right = sum;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (valid(mid, nums, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)left;
    }

    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
