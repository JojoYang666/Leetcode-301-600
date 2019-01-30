package leetcode_301To600;

import java.util.ArrayList;
import java.util.List;

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
public class _564_FindtheClosestPalindrome {

    /**
     * Given an integer n, find the closest integer (not including itself), which is a palindrome.

     The 'closest' is defined as absolute difference minimized between two integers.

     Example 1:

     Input: "123"
     Output: "121"

     Note:

     The input n is a positive integer represented by string, whose length will not exceed 18.
     If there is a tie, return the smaller one as answer.

     time : O(n)
     space : O(1)

     * @param n
     * @return
     */
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean isEven = (len % 2 == 0);
        int mid = isEven ? len / 2 - 1: len / 2;
        long left = Long.parseLong(n.substring(0, mid + 1));

        List<Long> candidate = new ArrayList<>();
        candidate.add(getPalindrome(left, isEven));
        candidate.add(getPalindrome(left + 1, isEven));
        candidate.add(getPalindrome(left - 1, isEven));
        candidate.add((long)Math.pow(10, len - 1) - 1);
        candidate.add((long)Math.pow(10, len) + 1);

        long diff = Long.MAX_VALUE;
        long res = 0;
        long num = Long.parseLong(n);
        for (long cand : candidate) {
            if (cand == num) continue;
            if (Math.abs(cand - num) < diff) {
                diff = Math.abs(cand - num);
                res = cand;
            } else if (Math.abs(cand - num) == diff) {
                res = Math.min(res, cand);
            }
        }

        return String.valueOf(res);
    }

    private long getPalindrome(long left, boolean even) {
        long res = left;
        if (!even) {
            left = left / 10;
        }
        while (left > 0) {
            res = res * 10 + left % 10;
            left /= 10;
        }
        return res;
    }
}
