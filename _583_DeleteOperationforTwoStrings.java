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
public class _583_DeleteOperationforTwoStrings {

    /**
     * Given two words word1 and word2, find the minimum number of steps required to
     * make word1 and word2 the same, where in each step you can delete one character in either string.

     Example 1:

     Input: "sea", "eat"
     Output: 2
     Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

     [0, 1, 2, 3]
     [1, 2, 3, 4]
     [2, 1, 2, 3]
     [3, 2, 1, 2]

     time : O(m * n)
     space : O(m * n)

     * @param s1
     * @param s2
     * @return
     */
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public int minDistance2(String s1, String s2) {
        int[] dp = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int[] temp = new int[s2.length() + 1];
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    temp[j] = i + j;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    temp[j] = dp[j - 1];
                } else {
                    temp[j] = 1 + Math.min(dp[j], temp[j - 1]);
                }
            }
            dp = temp;
        }
        return dp[s2.length()];
    }

}
