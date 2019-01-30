/*
 * 网站地址：cspiration.com
 * 课程：Leetcode Java 版本视频讲解
 * 创作人：Edward Shi
 */

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
public class _441_ArrangingCoins {
    /**
     * Example 1:

     n = 5

     The coins can form the following rows:
     ¤
     ¤ ¤
     ¤ ¤

     Because the 3rd row is incomplete, we return 2.
     Example 2:

     n = 8

     The coins can form the following rows:
     ¤
     ¤ ¤
     ¤ ¤ ¤
     ¤ ¤

     Because the 4th row is incomplete, we return 3.

     time : O(1)
     space : O(1)
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        int i = 0;
        while (n > 0) {
            i += 1;
            n -= i;
        }
        return n == 0 ? i : i - 1;
    }

    public int arrangeCoins2(int n) {
        return (int) ((Math.sqrt(1 + 8 * (long)n) - 1) / 2);
    }
}
