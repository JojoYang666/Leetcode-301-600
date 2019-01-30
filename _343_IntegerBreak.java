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
public class _343_IntegerBreak {
    /**
     * 343. Integer Break
     * Given a positive integer n, break it into the sum of at least two positive integers and
     * maximize the product of those integers. Return the maximum product you can get.

     For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

     2 : 1 + 1
     3 : 2 + 1
     4 : 2 + 2
     5 : 3 + 2
     6 : 3 + 3
     7 : 3 + 4
     8 : 3 + 3 + 2
     9 : 3 + 3 + 3
     10 : 3 + 3 + 4

     time : < O(n) O(1)
     space : O(1)

     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
