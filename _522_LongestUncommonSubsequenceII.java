package leetcode_301To600;

import java.util.Arrays;
import java.util.Comparator;

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
public class _522_LongestUncommonSubsequenceII {

    /**
     * Given a list of strings, you need to find the longest uncommon subsequence among them.
     * The longest uncommon subsequence is defined as the longest subsequence of
     * one of these strings and this subsequence should not be any subsequence of the other strings.

     A subsequence is a sequence that can be derived from one sequence by deleting some characters
     without changing the order of the remaining elements.
     Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

     The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence.
     If the longest uncommon subsequence doesn't exist, return -1.

     Example 1:

     Input: "aba", "cdc", "eae"
     Output: 3

     time : O(n^2 * min(a + b))
     space : O(1)
     */

    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (j == i) {
                    continue;
                }
                if (isSubsequence(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }

    public int findLUSlength2(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for (int i = 0, j; i < strs.length; i++) {
            boolean flag = true;
            for (j = 0; j < strs.length; j++) {
                if (j == i) {
                    continue;
                }
                if (isSubsequence(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return strs[i].length();
            }
        }
        return -1;
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }
}
