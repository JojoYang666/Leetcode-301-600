package leetcode_301To600;

import java.util.LinkedList;
import java.util.Queue;

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
public class _542_01Matrix {

    /**
     * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each point.

     The distance between two adjacent cells is 1.
     Example 1:
     Input:

     0 0 0
     0 1 0
     0 0 0
     Output:
     0 0 0
     0 1 0
     0 0 0
     Example 2:
     Input:

     0 0 0
     0 1 0
     1 1 1
     Output:
     0 0 0
     0 1 0
     1 2 1

     time : O(m * n)
     space : O(m * n)
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int[] dir : dirs) {
                int r = point[0] + dir[0];
                int c = point[1] + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix[r][c] <= matrix[point[0]][point[1]] + 1) {
                    continue;
                }
                queue.offer(new int[]{r, c});
                matrix[r][c] = matrix[point[0]][point[1]] + 1;
            }
        }

        return matrix;
    }
}
