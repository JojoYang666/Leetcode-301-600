package leetcode_301To600;

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
public class _524_LongestWordinDictionarythroughDeleting {
    /**
     * Given a string and a string dictionary,
     * find the longest string in the dictionary that can be formed by deleting
     * some characters of the given string. If there are more than one possible results,
     * return the longest word with the smallest lexicographical order. If there is no possible result,
     * return the empty string.

     Example 1:

     Input:
     s = "abpcplea", d = ["ale","apple","monkey","plea"]

     Output:
     "apple"
     Example 2:

     Input:
     s = "abpcplea", d = ["a","b","c"]

     Output:
     "a"

     time : O(m * n)
     space : O(1)
     */

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

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                if (str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }
        return res;
    }
}
