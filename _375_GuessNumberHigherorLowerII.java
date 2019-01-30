package leetcode_1To300;

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
public class _375_GuessNumberHigherorLowerII {
    /**
     * 375. Guess Number Higher or Lower II
     * We are playing the Guess Game. The game is as follows:

     I pick a number from 1 to n. You have to guess which number I picked.

     Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

     However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

     Example:

     n = 10, I pick 8.

     First round:  You guess 5, I tell you that it's higher. You pay $5.
     Second round: You guess 7, I tell you that it's higher. You pay $7.
     Third round:  You guess 9, I tell you that it's lower. You pay $9.

     Game over. 8 is the number I picked.

     You end up paying $5 + $7 + $9 = $21.
     Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

     1 2 3 4 5 6 7 (8) 9 10

     dp[i][j] : i - j 肯定赢所需多少钱

     最小的最大值问题：
     i - j 中，任意猜一个数x，获胜所花的钱为 x + max(helper(i ,x-1), helper(x+1 ,j))

     5 : 10 11


     1,for
     2,dfs + memo

     time : O(n^3)
     space : O(n^2)


     * @param n
     * @return
     */

    int[][] dp;

    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return helper(1, n);
    }

    private int helper(int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        int res = Integer.MAX_VALUE;
        for (int x = i; x <= j; x++) {
            res = Math.min(res, Math.max(helper(i, x - 1), helper(x + 1, j)) + x);
        }
        dp[i][j] = res;
        return res;
    }

    /**                    x
     * 1 2 3 4 5 6 7 (8) 9 10
     *             i        j
     * @param n
     * @return
     */

    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = i; x < j; x++) {
                    dp[i][j] = Math.min(dp[i][j], x + Math.max(dp[i][x - 1], dp[x + 1][j]));
                }
            }
        }
        return dp[1][n];
    }
}
