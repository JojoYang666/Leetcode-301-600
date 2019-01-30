package leetcode_1To300;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

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
public class _353_DesignSnakeGame {

    /**
     * 353. Design Snake Game
     */
    HashSet<Integer> set; // 位置
    Deque<Integer> deque;
    int score;
    int foodIndex;
    int width;
    int height;
    int[][] food;

    public _353_DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        deque = new LinkedList<>();
        score = 0;
        foodIndex = 0;
        set.add(0);
        deque.offerLast(0);
    }

    public int move(String direction) {
        if (score == -1) {
            return -1;
        }

        int rowHead = deque.peekFirst() / width;
        int colHead = deque.peekFirst() % width;

        switch (direction) {
            case "U" : rowHead--;
                break;
            case "D" : rowHead++;
                break;
            case "L" : colHead--;
                break;
            default : colHead++;
        }
        int head = rowHead * width + colHead;
        set.remove(deque.peekLast());
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }
        set.add(head);
        deque.offerFirst(head);
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            foodIndex++;
            ++score;
            set.add(deque.peekLast());
            return score;
        }
        deque.pollLast();
        return score;
    }
}
