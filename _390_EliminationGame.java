package leetcode_1To300;

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
public class _390_EliminationGame {
    /**
     * 390. Elimination Game
     * Example:

     Input:
     n = 8,
     1 2 3 4 5 6 7 8
       2   4   6   8 res = 2
       2       6     res = 2
               6     res = 6


     1 2 3 4 5 6 7
       2   4   6
           4

     Output:
     6

     time : O(logn)
     space : O(1)

     * @param n
     * @return
     */
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int res = 1; // head
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                res = res + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return res;
    }
}
