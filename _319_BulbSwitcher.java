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
public class _319_BulbSwitcher {
    /**
     * 319. Bulb Switcher
     * There are n bulbs that are initially off. You first turn on all the bulbs.
     * Then, you turn off every second bulb. On the third round, you toggle every third bulb
     * (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round,
     * you only toggle the last bulb. Find how many bulbs are on after n rounds.

     Example:

     Given n = 3.

     At first, the three bulbs are [off, off, off].
     After first round, the three bulbs are [on, on, on].
     After second round, the three bulbs are [on, off, on].
     After third round, the three bulbs are [on, off, off].

     So you should return 1, because there is only one bulb is on.

     time : O(1)
     space : O(1)


     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
