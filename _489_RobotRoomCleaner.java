package leetcode_301To600;

import java.util.HashSet;

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
public class _489_RobotRoomCleaner {

    /**
     * Given a robot cleaner in a room modeled as a grid.

     Each cell in the grid can be empty or blocked.

     The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.

     When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.

     Design an algorithm to clean the entire room using only the 4 given APIs shown below.

     interface Robot {
     // returns true if next cell is open and robot moves into the cell.
     // returns false if next cell is obstacle and robot stays on the current cell.
     boolean move();

     // Robot will stay on the same cell after calling turnLeft/turnRight.
     // Each turn will be 90 degrees.
     void turnLeft();
     void turnRight();

     // Clean the current cell.
     void clean();
     }
     Example:

     Input:
     room = [
     [1,1,1,1,1,0,1,1],
     [1,1,1,1,1,0,1,1],
     [1,0,1,1,1,1,1,1],
     [0,0,0,1,0,0,0,0],
     [1,1,1,1,1,1,1,1]
     ],
     row = 1,
     col = 3

     Explanation:
     All grids in the room are marked by either 0 or 1.
     0 means the cell is blocked, while 1 means the cell is accessible.
     The robot initially starts at the position of row=1, col=3.
     From the top left corner, its position is one row below and three columns right.

     */

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void cleanRoom(Robot robot) {
        backtracking(robot, 0, 0, 0, new HashSet<>());
    }

    public void backtracking(Robot robot, int x, int y, int curDir, HashSet<String> visited) {
        visited.add(x + "-" + y);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextDir = (curDir + i) % 4;
            int newX = x + dirs[nextDir][0];
            int newY = y + dirs[nextDir][1];
            if (!visited.contains(newX + "-" + newY) && robot.move()) {
                backtracking(robot, newX, newY, nextDir, visited);
            }
            robot.turnRight();
        }
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();
        void turnRight();

        // Clean the current cell.
        void clean();
    }
}
