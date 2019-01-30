package leetcode_1To300;

import java.util.HashMap;

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
public class _316_RemoveDuplicateLetters {
    /**
     * 316. Remove Duplicate Letters
     * Given a string which contains only lowercase letters, remove duplicate letters
     * so that every letter appear once and only once. You must make sure your result is the smallest
     * in lexicographical order among all possible results.

     Example:
     Given "bcabc"
     Return "abc"

     Given "cbacdcbc"
     Return "acdb"

     c b a c d c b c
     0 1 2 3 4 5 6 7

     map :



     cba start = 3 end = 4 a
     cd start = 4 end = 4 ac
     d start = 5 end = 6 acd
     cb start = 7 end    acdb

     time : O(n)
     space : O(n)


     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        char[] res = new char[map.size()];
        int start = 0, end = findMinLastPos(map);
        for (int i = 0; i < res.length; i++) {
            char minChar = 'z' + 1;
            for (int k = start; k <= end; k++) {
                if (map.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    start = k + 1;
                }
            }
            res[i] = minChar;
            map.remove(minChar);
            if (s.charAt(end) == minChar) {
                end = findMinLastPos(map);
            }
        }
        return new String(res);
    }

    public int findMinLastPos(HashMap<Character, Integer> map) {
        int res = Integer.MAX_VALUE;
        for (int num : map.values()) {
            res = Math.min(res, num);
        }
        return res;
    }
}
