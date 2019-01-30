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
public class _518_CoinChange2 {

    /**
     * You are given coins of different denominations and a total amount of money.
     * Write a function to compute the number of combinations that make up that amount.
     * You may assume that you have infinite number of each kind of coin.

     Example 1:

     Input: amount = 5, coins = [1, 2, 5]
     Output: 4
     Explanation: there are four ways to make up the amount:
     5=5
     5=2+2+1
     5=2+1+1+1
     5=1+1+1+1+1
     Example 2:

     Input: amount = 3, coins = [2]
     Output: 0
     Explanation: the amount of 3 cannot be made up just with coins of 2.
     Example 3:

     Input: amount = 10, coins = [10]
     Output: 1

     time : O(m * n)
     space : O(m)

     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
