package leetcode_301To600;

import java.util.HashSet;

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
public class _409_LongestPalindrome {
    /**
     * Input:
     "abccccdd"

     Output:
     7

     Explanation:
     One longest palindrome that can be built is "dccaccd", whose length is 7.

     time : O(n)
     * @param s
     * @return
     */
    // space : O(n)
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        if (set.size() != 0) return count * 2 + 1;
        return count * 2;
    }
    // space : O(1)
    public int longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] count = new char[256];
        int res = 0;
        boolean bool = false;
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
                res++;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) bool = true;
        }
        if (bool) return res * 2 + 1;
        return res * 2;
    }
}
