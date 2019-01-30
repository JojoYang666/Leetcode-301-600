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
public class _416_PartitionEqualSubsetSum {

    /**
     * Given a non-empty array containing only positive integers,
     * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

     Note:

     Each of the array element will not exceed 100.
     The array size will not exceed 200.
     Example 1:

     Input: [1, 5, 11, 5]

     Output: true

     Explanation: The array can be partitioned as [1, 5, 5] and [11].
     Example 2:

     Input: [1, 2, 3, 5]

     Output: false

     Explanation: The array cannot be partitioned into equal sum subsets.

     dp[i]  i : 是否是原数组的任意子集之和

     关于倒叙：视频里例子举的不好 拿[1, 5, 11, 5]来说
     在 num = 1 的循环条件下
     dp[0] = true
     dp[1] = true
     dp[2] = dp[2] || dp[2 - 1] = true
     dp[3] = dp[3] || dp[3 - 1] = true ... 所以全为true

     * time : O(n * sum / 2)
     * space : O(sum)
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }
}
