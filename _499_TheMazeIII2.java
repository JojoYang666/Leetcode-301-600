package leetcode_301To600;

import java.util.PriorityQueue;

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
public class _499_TheMazeIII2 {

    class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;
        String ori;
        Point(int x, int y, int dist, String ori){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.ori = ori;
        }
        public int compareTo(Point other) {
            return this.dist == other.dist ? this.ori.compareTo(other.ori) : this.dist - other.dist;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        String[] ori = new String[]{"d", "u", "r", "l"};

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Point point = new Point(ball[0], ball[1], 0, "");
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(point);

        while (!pq.isEmpty()){
            Point cur = pq.poll();
            if (cur.x == hole[0] && cur.y == hole[1]) {
                return cur.ori;
            }
            visited[cur.x][cur.y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = cur.x;
                int newY = cur.y;
                int dist = cur.dist;
                String curOri = cur.ori;

                while (isValid(maze, newX + directions[i][0], newY + directions[i][1])) {
                    if (newX == hole[0] && newY == hole[1]) {
                        break;
                    }
                    newX += directions[i][0];
                    newY += directions[i][1];
                    dist++;
                }
                if (!visited[newX][newY]) {
                    pq.offer(new Point(newX, newY, dist,curOri + ori[i]));
                }
            }
        }

        return "impossible";
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x<maze.length && y<maze[0].length && maze[x][y]==0;
    }
}
