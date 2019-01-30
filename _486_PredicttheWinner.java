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
public class _486_PredicttheWinner {

    /**
     * Given an array of scores that are non-negative integers.
     * Player 1 picks one of the numbers from either end of the array followed by the player
     * 2 and then player 1 and so on. Each time a player picks a number,
     * that number will not be available for the next player.
     * This continues until all the scores have been chosen.
     * The player with the maximum score wins.

     Given an array of scores, predict whether player 1 is the winner.
     You can assume each player plays to maximize his score.

     Example 1:

     Input: [1, 5, 2]
     Output: False
     Explanation: Initially, player 1 can choose between 1 and 2.
     If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5.
     If player 2 chooses 5, then player 1 will be left with 1 (or 2).
     So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
     Hence, player 1 will never be the winner and you need to return False.
     Example 2:

     Input: [1, 5, 233, 7]
     Output: True
     Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7.
     No matter which number player 2 choose, player 1 can choose 233.
     Finally, player 1 has more score (234) than player 2 (12), so you need to return True
     representing player1 can win.

     time : O(n ^ 2)
     space : O(n)

     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        } else {
            return Math.max(nums[start] - helper(nums, start + 1, end),
                    nums[end] - helper(nums, start, end - 1));
        }
    }

    public boolean PredictTheWinner2(int[] nums) {
        return helper2(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
    }

    private int helper2(int[] nums, int start, int end, Integer[][] dp) {
        if (dp[start][end] == null) {
            if (start == end) {
                return nums[start];
            } else {
                return dp[start][end] = Math.max(nums[start] - helper2(nums, start + 1, end, dp),
                        nums[end] - helper2(nums, start, end - 1, dp));
            }
        }
        return dp[start][end];
    }

    public boolean PredictTheWinner3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][i] = nums[i];
                } else {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public boolean PredictTheWinner4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i] = nums[i];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[n - 1] >= 0;
    }
}
