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
public class _576_OutofBoundaryPaths {

    /**
     * time : O(m * n * N)
     * space : O(m * n)
     * @param m
     * @param n
     * @param N
     * @param i
     * @param j
     * @return
     */
    public static int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) {
            return 0;
        }

        final int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int res = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] dir : dirs) {
                        int newR = r + dir[0];
                        int newC = c + dir[1];
                        if (newR < 0 || newR >= m || newC < 0 || newC >= n) {
                            res = (res + dp[r][c]) % MOD;
                        } else {
                            temp[newR][newC] = (temp[newR][newC] + dp[r][c]) % MOD;
                        }
                    }
                }
            }
            dp = temp;
        }

        return res;
    }
}
