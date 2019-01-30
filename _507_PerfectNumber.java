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
public class _507_PerfectNumber {

    /**
     * We define the Perfect Number is a positive integer that is equal to the res of all its positive divisors
     * except itself.

     Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
     Example:

     Input: 28
     Output: True
     Explanation: 28 = 1 + 2 + 4 + 7 + 14

     time : O(sqrt(n))
     space : O(1)

     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 1 ) {
            return false;
        }
        int res = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                res += i + num / i;
            }
        }
        return res == num;
    }
}