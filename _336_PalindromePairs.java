package leetcode_1To300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class _336_PalindromePairs {
    /**
     * 336. Palindrome Pairs
     * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
     * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

     Example 1:
     Given words = ["bat", "tab", "cat"]
     Return [[0, 1], [1, 0]]
     The palindromes are ["battab", "tabbat"]
     Example 2:
     Given words = ["abcd", "dcba", "lls", "s", "sssll"]
     Return [[0, 1], [1, 0], [3, 2], [2, 4]]
     The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

     "abcdc" "ab"

     ab"cdc ab"
     "a" a

     time : O(n * k^2)
     space : O(n)

     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        res.add(Arrays.asList(map.get(str2rvs), i));
                    }
                }
                if (str2.length() != 0 && isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i) {
                        res.add(Arrays.asList(i, map.get(str1rvs)));
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
