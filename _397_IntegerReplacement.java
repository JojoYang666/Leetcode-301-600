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
public class _397_IntegerReplacement {
    /**
     * 397. Integer Replacement
     * Given a positive integer n and you can do operations as follow:

     If n is even, replace n with n/2.
     If n is odd, you can replace n with either n + 1 or n - 1.
     What is the minimum number of replacements needed for n to become 1?

     Example 1:

     Input:
     8

     Output:
     3

     Explanation:
     8 -> 4 -> 2 -> 1
     Example 2:

     Input:
     7

     Output:
     4

     Explanation:
     7 -> 8 -> 4 -> 2 -> 1
     or
     7 -> 6 -> 3 -> 2 -> 1

     time : O(logn)
     space : O(1)
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        long N = n;
        int res = 0;
        while (N != 1) {
            if (N % 2 == 0) {
                N >>= 1;
            } else {
                if (N == 3) {
                    res += 2;
                    break;
                }
                N = (N & 2) == 2 ? N + 1 : N - 1;
            }
            res++;
        }
        return res;
    }

    /**
     * time : O(logn)
     * space : O(1)

     * @param n
     * @return
     */

    public int integerReplacement2(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        int res = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                if ( (n + 1) % 4 == 0 && (n - 1 != 2)) {
                    n++;
                } else n--;
            }
            res++;
        }
        return res;
    }
}
