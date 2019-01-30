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
public class _440_KthSmallestinLexicographicalOrder {

    /**
     * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.

     Note: 1 ≤ k ≤ n ≤ 109.

     Example:

     Input:
     n: 13   k: 2

     Output:
     10

     Explanation:
     The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

     time : O((logk ~ k)logn)
     space : O(1)

     * @param n
     * @param k
     * @return
     */
    public static int findKthNumber(int n, int k) {
        int res = 1;
        k = k - 1;
        while (k > 0) {
            int steps = 0;
            long first = res, last = res + 1;
            while (first <= n) {
                steps += Math.min(n + 1, last) - first;
                first *= 10;
                last *= 10;
            }

            if (steps <= k) {
                res++;
                k -= steps;
            } else {
                res *= 10;
                k--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findKthNumber(13, 4);
    }
}
