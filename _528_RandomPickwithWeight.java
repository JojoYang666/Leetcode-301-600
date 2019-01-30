package leetcode_301To600;

import java.util.Random;

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
public class _528_RandomPickwithWeight {

    /**
     * Given an array w of positive integers, where w[i] describes the weight of index i,
     * write a function pickIndex which randomly picks an index in proportion to its weight.

     Note:

     1 <= w.length <= 10000
     1 <= w[i] <= 10^5
     pickIndex will be called at most 10000 times.
     Example 1:

     Input:
     ["Solution","pickIndex"]
     [[[1]],[]]
     Output: [null,0]
     Example 2:

     Input:
     ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
     [[[1,3]],[],[],[],[],[]]
     Output: [null,0,1,1,1,0]

     time : O(n)
     space : O(n)

     * @param w
     */

    Random rmd;
    int[] sum;

    public _528_RandomPickwithWeight(int[] w) {
        this.rmd = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.sum = w;
    }

    /**
     * time : O(logn)
     * @return
     */
    public int pickIndex() {
        int index = rmd.nextInt(sum[sum.length - 1]) + 1;
        int left = 0;
        int right = sum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] == index) {
                return mid;
            } else if (sum[mid] < index) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
