package leetcode_1To300;

import java.util.Arrays;

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
public class _354_RussianDollEnvelopes {
    /**
     * 354. Russian Doll Envelopes
     * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
     * One envelope can fit into another if and only if both the width and height of one envelope
     * is greater than the width and height of the other envelope.

     What is the maximum number of envelopes can you Russian doll? (put one inside other)

     Example:
     Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll
     is 3 ([2,3] => [5,4] => [6,7]).

     排序
     weight ->
     height <-

     [6 4][6 7]

     [2, 3] -> [5, 4] -> [6, 7] -> [6, 4]

     3 4 7 4 -> 3 4 7

     time : O(nlogn)
     space : O(n)

     * @param envelopes
     * @return
     */

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int[] envelope : envelopes) {
            int i = binarySearch(dp, 0, res, envelope[1]);
            dp[i] = envelope[1];
            if (i == res) {
                res++;
            }
        }
        return res;
    }

    public int binarySearch(int[] dp, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (dp[start] >= target) return start;
        return end;
    }
}
