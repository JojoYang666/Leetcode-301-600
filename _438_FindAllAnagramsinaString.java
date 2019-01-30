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
public class _438_FindAllAnagramsinaString {
    /**
     * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

     Strings consists of lowercase English letters only and the length of
     both strings s and p will not be larger than 20,100.

     The order of output does not matter.

     Example 1:

     Input:
     s: "cbaebabacd" p: "abc"

     Output:
     [0, 6]

     Explanation:
     The substring with start index = 0 is "cba", which is an anagram of "abc".
     The substring with start index = 6 is "bac", which is an anagram of "abc".

     0 1 2 3 4 5 6 7 8 9
     c b a e b a b a c d
                   e
             s

     time : O(n)
     space : O(n)


     * @param s
     * @param p
     * @return
     */

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return res;
        int[] chars = new int[26];
        for (char c : p.toCharArray()) {
            chars[c - 'a']++;
        }
        int start = 0, end = 0;
        int count = p.length();
        while (end < s.length()) {
            if (end - start == p.length() && chars[s.charAt(start++) - 'a'] >= 0) {
                count++;
            }
            if (--chars[s.charAt(end++) - 'a'] >= 0) {
                count--;
            }
            if (count == 0) res.add(start);
        }
        return res;
    }
}
