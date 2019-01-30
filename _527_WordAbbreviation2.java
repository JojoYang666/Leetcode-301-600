package leetcode_301To600;

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
public class _527_WordAbbreviation2 {

    /**
     * time : O(m * n)
     * space : O(m * n)
     * @param dict
     * @return
     */
    public List<String> wordsAbbreviation(List<String> dict) {
        HashMap<String, List<IndexedWord>> map = new HashMap();
        String[] res = new String[dict.size()];

        int index = 0;
        for (String word: dict) {
            String abbr = abbrev(word, 0);
            if (!map.containsKey(abbr)) {
                map.put(abbr, new ArrayList());
            }
            map.get(abbr).add(new IndexedWord(word, index));
            index++;
        }

        for (List<IndexedWord> indexedWords: map.values()) {
            TrieNode root = new TrieNode();
            for (IndexedWord iw: indexedWords) {
                TrieNode cur = root;
                for (char letter: iw.word.substring(1).toCharArray()) {
                    if (cur.children[letter - 'a'] == null)
                        cur.children[letter - 'a'] = new TrieNode();
                    cur.count++;
                    cur = cur.children[letter - 'a'];
                }
            }

            for (IndexedWord iw: indexedWords) {
                TrieNode cur = root;
                int i = 1;
                for (char letter: iw.word.substring(1).toCharArray()) {
                    if (cur.count == 1) break;
                    cur = cur.children[letter - 'a'];
                    i++;
                }
                res[iw.index] = abbrev(iw.word, i-1);
            }
        }

        return Arrays.asList(res);
    }

    public String abbrev(String word, int i) {
        int n = word.length();
        if (n - i <= 3) {
            return word;
        }
        return word.substring(0, i + 1) + (n - i - 2) + word.charAt(n - 1);
    }

    class TrieNode {
        TrieNode[] children;
        int count;
        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }
    class IndexedWord {
        String word;
        int index;
        IndexedWord(String w, int i) {
            word = w;
            index = i;
        }
    }

}
