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
public class _483_SmallestGoodBase {

    /**
     * For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.

     Now given a string representing n, you should return the smallest good base of n in string format.

     Example 1:

     Input: "13"
     Output: "3"
     Explanation: 13 base 3 is 111.
     Example 2:

     Input: "4681"
     Output: "8"
     Explanation: 4681 base 8 is 11111.
     Example 3:

     Input: "1000000000000000000"
     Output: "999999999999999999"
     Explanation: 1000000000000000000 base 999999999999999999 is 11.
     Note:

     The range of n is [3, 10^18].
     The string representing n is always valid and will not have leading zeros.

     time : O(logn * logn * logn)
     space : O(1)

     * @param n
     * @return
     */
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);

        for (int m = (int)(Math.log(num + 1) / Math.log(2)); m > 2; m--) {
            long l = 2;
            long r = (long)(Math.pow(num, 1.0 / (m - 1)));
            while (l <= r) {
                long k = l + (r - l) / 2;
                long sum = 0, cur = 1;
                for (int i = 0; i < m; i++) {
                    sum += cur;
                    cur *= k;
                }
                if (num == sum) {
                    return String.valueOf(k);
                } else if (num < sum) {
                    r = k - 1;
                } else {
                    l = k + 1;
                }
            }
        }

        return String.valueOf(num - 1);
    }
}
