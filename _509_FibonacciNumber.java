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
public class _509_FibonacciNumber {

    /**
     * he Fibonacci numbers, commonly denoted F(n) form a sequence,
     * called the Fibonacci sequence, such that each number is the sum of the two preceding ones,
     * starting from 0 and 1. That is,

     F(0) = 0,   F(1) = 1
     F(N) = F(N - 1) + F(N - 2), for N > 1.
     Given N, calculate F(N).



     Example 1:

     Input: 2
     Output: 1
     Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
     Example 2:

     Input: 3
     Output: 2
     Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
     Example 3:

     Input: 4
     Output: 3
     Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

     * @param N
     * @return
     */
    public int fib(int N) {
        if (N <= 1) {
            return N;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        int a = 0, b = 1;
        while (N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    int[] fib = new int[31];

    public int fib4(int N) {
        if (N <= 1) {
            return N;
        }
        if (fib[N] != 0) {
            return fib[N];
        } else {
            return fib[N] = fib[N - 1] + fib[N - 2];
        }
    }
}
