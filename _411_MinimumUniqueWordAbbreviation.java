package leetcode_301To600;

import java.util.*;

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
public class _411_MinimumUniqueWordAbbreviation {

    /**
     * A string such as "word" contains the following abbreviations:

     ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
     Given a target string and a set of strings in a dictionary,
     find an abbreviation of this target string with the smallest possible length
     such that it does not conflict with abbreviations of the strings in the dictionary.

     Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.

     Note:

     In the case of multiple answers as shown in the second example below, you may return any one of them.
     Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.
     Examples:

     "apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

     "apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").


     * @param target
     * @param dictionary
     * @return
     */
    TrieNode root = new TrieNode();

    public String minAbbreviation(String target, String[] dictionary) {
        for (String word : dictionary) {
            addWord(word);
        }
        List<String> abbr = new ArrayList<>();
        addAbbr(abbr, target, new String(), 0, 0);
        Collections.sort(abbr, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        for (String word : abbr) {
            if (!search(word, root, 0, 0)) {
                return word;
            }
        }
        return "";
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word, TrieNode root, int pos, int count) {
        if (root == null) return false;
        if (count != 0) {
            for (int i = 0; i < 26; i++) {
                if (search(word, root.children[i], pos, count - 1)) return true;
            }
            return false;
        }
        if (pos == word.length()) {
            if (root.isWord) {
                return true;
            }
            return false;
        }
        int i = pos;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (c >= '0' && c <= '9') {
                count = count * 10 + c - '0';
                i++;
            } else {
                break;
            }
        }
        if (count == 0) {
            char c = word.charAt(i);
            return search(word, root.children[c - 'a'], i + 1, count);
        }
        return search(word, root, i, count);
    }

    public void addAbbr(List<String> res, String word, String cur, int pos, int count) {
        if (pos == word.length()) {
            if (count != 0) {
                cur += count;
            }
            res.add(cur);
            return;
        }
        // 加数字
        addAbbr(res, word, cur, pos + 1, count + 1);
        if (count != 0) {
            cur += count;
        }
        // 加字母
        addAbbr(res, word, cur + word.charAt(pos), pos + 1, 0);
    }

    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
}
