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
public class _562_LongestLineofConsecutiveOneinMatrix {

    /**
     * Given a 01 M M, find the longest line of consecutive one in the M.
     * The line could be horizontal, vertical, diagonal or anti-diagonal.
     Example:

     Input:
     [
     [0,1,1,0],
     [0,1,1,0],
     [0,0,0,1]
     ]
     Output: 3

     time : O(m * n)
     space : O(m + n)

     * @param M
     * @return
     */
    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int res = 0;
        int[] col = new int[M[0].length];
        int[] antiD = new int[M.length + M[0].length];
        int[] diag = new int[M.length + M[0].length];
        for (int i = 0; i < M.length; i++) {
            int row = 0;
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    row++;
                    col[j]++;
                    antiD[i + j]++;
                    diag[j - i + M.length]++;
                    res = Math.max(res, row);
                    res = Math.max(res, col[j]);
                    res = Math.max(res, antiD[i + j]);
                    res = Math.max(res, diag[j - i + M.length]);
                } else {
                    row = 0;
                    col[j] = 0;
                    antiD[i + j] = 0;
                    diag[j - i + M.length] = 0;
                }
            }
        }
        return res;
    }
}
