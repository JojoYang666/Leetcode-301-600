package leetcode_301To600;

import java.util.Arrays;
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
public class _505_TheMazeII {
    /**
     * time : O(m * n)
     * space : O(m * n)
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][] dists = new int[maze.length][maze[0].length];
        for (int[] dist : dists) {
            Arrays.fill(dist, -1);
        }
        dists[start[0]][start[1]] = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1]));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int[] direction : directions) {
                int newX = cur.x;
                int newY = cur.y;
                int dist = dists[newX][newY];
                while (isValid(maze, newX + direction[0], newY + direction[1])) {
                    newX += direction[0];
                    newY += direction[1];
                    dist++;
                }
                if (dists[newX][newY] == -1 ||  dist < dists[newX][newY]) {
                    queue.offer(new Point(newX, newY));
                    dists[newX][newY] = dist;
                }
            }
        }
        return dists[destination[0]][destination[1]];
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
