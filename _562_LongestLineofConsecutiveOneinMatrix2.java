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
public class _562_LongestLineofConsecutiveOneinMatrix2 {

    /**
     * time : O(m * n)
     * space : O(m * n)
     * @param M
     * @return
     */
    public int longestLine2(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int m = M.length;
        int n = M[0].length;
        int[][][] lengths = new int[m][n][4];
        int res = 0;
        int[][] directions = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) {
                    continue;
                }
                int k = 0;
                for (int[] direction : directions) {
                    int row = i + direction[0];
                    int col = j + direction[1];
                    lengths[i][j][k] = row >= 0 && col >= 0 && col < n ? lengths[row][col][k] + 1 : 1;
                    res = Math.max(res, lengths[i][j][k]);
                    k++;
                }
            }
        }
        return res;
    }
}
