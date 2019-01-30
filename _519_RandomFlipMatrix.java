package leetcode_301To600;

import java.util.HashMap;
import java.util.Random;

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
public class _519_RandomFlipMatrix {


    /**
     * You are given the number of rows n_rows and number of columns n_cols of a 2D binary matrix 
     * where all values are initially 0. Write a function flip which chooses a 0 value uniformly at random,
     * changes it to 1, and then returns the position [row.id, col.id] of that value. Also, 
     * write a function reset which sets all values back to 0. 
     * Try to minimize the number of calls to system's Math.random() and optimize the time and space complexity.

     Note:

     1 <= n_rows, n_cols <= 10000
     0 <= row.id < n_rows and 0 <= col.id < n_cols
     flip will not be called when the matrix has no 0 values left.
     the total number of calls to flip and reset will not exceed 1000.
     Example 1:

     Input: 
     ["Solution","flip","flip","flip","flip"]
     [[2,3],[],[],[],[]]
     Output: [null,[0,1],[1,2],[1,0],[1,1]]
     Example 2:

     Input: 
     ["Solution","flip","flip","reset","flip"]
     [[1,2],[],[],[],[]]
     Output: [null,[0,0],[0,1],null,[0,0]]

     Fisher–Yates shuffle

     time : O(1)
     space : O(n)
     */

    HashMap<Integer, Integer> map;
    int m, n;
    int total;
    Random random;

    public _519_RandomFlipMatrix(int n_rows, int n_cols) {
        map = new HashMap<>();
        random = new Random();
        m = n_rows;
        n = n_cols;
        reset();
    }

    public int[] flip() {
        int rand = random.nextInt(total--);
        int res = map.getOrDefault(rand, rand);
        map.put(rand, map.getOrDefault(total, total));
        map.put(total, res);
        return new int[]{res / n, res % n};
    }

    public void reset() {
        total = m * n;
    }
}
