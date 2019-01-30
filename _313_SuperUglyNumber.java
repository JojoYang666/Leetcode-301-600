package leetcode_1To300;

import java.util.PriorityQueue;

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
public class _313_SuperUglyNumber {
    /**
     * 313. Super Ugly Number
     * Write a program to find the nth super ugly number.

     Super ugly numbers are positive numbers whose all prime factors are in the given prime list
     primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
     is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

     PriorityQueue kth

     time : O(n * logk)
     space : O(max(n,k))

     * @param n
     * @param primes
     * @return
     */

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;

        PriorityQueue<Num> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (int i = 0; i < primes.length; i++) {
            pq.add(new Num(primes[i], 1, primes[i]));
        }

        for (int i = 1; i < n; i++) {
            res[i] = pq.peek().val;
            while (pq.peek().val == res[i]) {
                Num next = pq.poll();
                pq.add(new Num(next.prime * res[next.index], next.index + 1, next.prime));
            }
        }

        return res[n - 1];
    }

    class Num {
        int val;
        int index;
        int prime;

        public Num(int val, int index, int prime) {
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
    }
}
