package leetcode_301To600;

import java.util.ArrayList;
import java.util.List;

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
public class _417_PacificAtlanticWaterFlow {

    /**
     Given the following 5x5 matrix:

     Pacific   ~   ~   ~   ~   ~
            ~  1   2   2   3  (5) *
            ~  3   2   3  (4) (4) *
            ~  2   4  (5)  3   1  *
            ~ (6) (7)  1   4   5  *
            ~ (5)  1   1   2   4  *
               *   *   *   *   * Atlantic

     Return:

     [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

     time : O(m * n)
     space : O(m * n)

     * @param matrix
     * @return
     */

    int m;
    int n;

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        m = matrix.length;
        if (m == 0) return res;
        n = matrix[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            helper(matrix, pac, i, 0);
            helper(matrix, atl, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            helper(matrix, pac, 0, i);
            helper(matrix, atl, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }

        return res;
    }

    public void helper(int[][] matrix, boolean[][] isVisited, int i, int j) {
        isVisited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= m || y >= m || isVisited[x][y] || matrix[i][j] > matrix[x][y]) {
                continue;
            }
            helper(matrix, isVisited, x, y);
        }
    }
}
