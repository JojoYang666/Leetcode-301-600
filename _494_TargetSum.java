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
public class _494_TargetSum {

    /**
     * You are given a list of non-negative integers, a1, a2, ..., an,
     * and a target, S. Now you have 2 symbols + and -. For each integer,
     * you should choose one from + and - as its new symbol.

     Find out how many ways to assign symbols to make sum of integers equal to target S.

     Example 1:

     Input: nums is [1, 1, 1, 1, 1], S is 3.
     Output: 5
     Explanation:

     -1+1+1+1+1 = 3
     +1-1+1+1+1 = 3
     +1+1-1+1+1 = 3
     +1+1+1-1+1 = 3
     +1+1+1+1-1 = 3

     There are 5 ways to assign symbols to make the sum of nums be target 3.

     Note:

     The length of the given array is positive and will not exceed 20.
     The sum of elements in the given array will not exceed 1000.
     Your output answer is guaranteed to be fitted in a 32-bit integer.

     time : O(n ^ 2)
     space : O(n)

     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || S < -sum) {
            return 0;
        }
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[2 * sum + 1];
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (dp[j] != 0) {
                    next[j + nums[i]] += dp[j];
                    next[j - nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[sum + S];
    }
}
