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
public class _479_LargestPalindromeProduct {

    /**
     * Find the largest palindrome made from the product of two n-digit numbers.

     Since the result could be very large, you should return the largest palindrome mod 1337.

     Example:

     Input: 2

     Output: 987

     Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

     Note:

     The range of n is [1,8].

     time : O(10^n) 不知道
     space : O(1)

     * @param n
     * @return
     */
    public int largestPalindrome(int n) {
        long max = (long)Math.pow(10, n) - 1;
        long min = max / 10;
        for (long left = max; left > min; left--) {
            long right = Long.parseLong(new StringBuilder("" + left).reverse().toString());
            long target = left * (max + 1) + right;
            for (long i = max; i * i >= target; i--) {
                if (target % i == 0) {
                    return (int)(target % 1337);
                }
            }
        }
        return 9;
    }
}
