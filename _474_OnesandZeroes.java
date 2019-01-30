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
public class _474_OnesandZeroes {

    /**
     * In the computer world, use restricted resource you have to generate maximum benefit is
     * what we always want to pursue.

     For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand,
     there is an array with strings consisting of only 0s and 1s.

     Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
     Each 0 and 1 can be used at most once.

     Note:

     The given numbers of 0s and 1s will both not exceed 100
     The size of given string array won't exceed 600.
     Example 1:

     Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
     Output: 4

     Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s,
     which are “10,”0001”,”1”,”0”
     Example 2:

     Input: Array = {"10", "0", "1"}, m = 1, n = 1
     Output: 2

     Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

     time : O(l * m * n)
     space : O(m * n)

     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = helper(s);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] helper(String s) {
        int[] count = new int[2];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - '0']++;
        }
        return count;
    }
}
