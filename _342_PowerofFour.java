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
public class _342_PowerofFour {

    /**
     * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

     Example:
     Given num = 16, return true. Given num = 5, return false.

     Follow up: Could you solve it without loops/recursion?


     * @param n
     * @return
     */

    // time : < O(n)
    public boolean isPowerOfFour(int n) {
        if (n > 1) {
            while (n % 4 == 0) {
                n /= 4;
            }
        }
        return n == 1;
    }

    // time : O(1)
    public boolean isPowerOfFour2(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }
}
