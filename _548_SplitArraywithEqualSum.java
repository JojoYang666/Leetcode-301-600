package leetcode_301To600;

import java.util.HashSet;

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
public class _548_SplitArraywithEqualSum {
    /**
     * Given an array with n integers, you need to find if there are triplets (i, j, k)
     * which satisfies following conditions:

     0 < i, i + 1 < j, j + 1 < k < n - 1
     Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
     where we define that subarray (L, R) represents a slice of the original array starting
     from the element indexed L to the element indexed R.

     Example:

     Input: [1,2,1,2,1,2,1]
     Output: True
     Explanation:
     i = 1, j = 3, k = 5.
     sum(0, i - 1) = sum(0, 0) = 1
     sum(i + 1, j - 1) = sum(2, 2) = 1
     sum(j + 1, k - 1) = sum(4, 4) = 1
     sum(k + 1, n - 1) = sum(6, 6) = 1

     time : O(n^2)
     space : O(n)
     * @param nums
     * @return
     */
    public boolean splitArray(int[] nums) {
        if (nums.length < 7) {
            return false;
        }

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int j = 3; j < nums.length - 3; j++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i]) {
                    set.add(sum[i - 1]);
                }
            }
            for (int k = j + 2; k < nums.length - 1; k++) {
                if (sum[nums.length - 1] - sum[k] == sum[k - 1] - sum[j] &&
                        set.contains(sum[k - 1] - sum[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
