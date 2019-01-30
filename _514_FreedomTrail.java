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
public class _514_FreedomTrail {

    /**
     * time : O(m * n * n)
     * space : O(m * n)
     * 不确定
     * @param ring
     * @param key
     * @return
     */
    public int findRotateSteps(String ring, String key) {
        return helper(ring, key, 0, 0, new int[ring.length()][key.length()]);
    }

    private int helper(String ring, String target, int ringIndex, int targetIndex, int[][] memo) {
        if (targetIndex == target.length()) {
            return 0;
        }

        if (memo[ringIndex][targetIndex] != 0) {
            return memo[ringIndex][targetIndex];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) != target.charAt(targetIndex)) {
                continue;
            }
            int diff = Math.abs(i - ringIndex);
            int distance = 1 + Math.min(diff, ring.length() - diff)
                    + helper(ring, target, i, targetIndex + 1, memo);
            min = Math.min(min, distance);
        }
        memo[ringIndex][targetIndex] = min;
        return min;
    }

    /**
     * time : O(m * n * n)
     * space : O(m * n)
     * @param ring
     * @param key
     * @return
     */
    public int findRotateSteps2(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }

        return dp[0][0] + m;
    }
}
