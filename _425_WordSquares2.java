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
public class _425_WordSquares2 {

    /**
     * time : O(n!) & O(N * L) N : words L : max(len)
     * space : O(nL) 不确定
     */
    TrieNode root;

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        root = new TrieNode();
        buildTrie(words);
        findSquare(res, new ArrayList<>(), words[0].length());
        return res;
    }

    private void findSquare(List<List<String>> res, List<String> candidate, int len) {
        if (candidate.size() == len) {
            res.add(new ArrayList<>(candidate));
            return;
        }
        int index = candidate.size();
        StringBuilder sb = new StringBuilder();
        for (String s : candidate) {
            sb.append(s.charAt(index));
        }
        String s = sb.toString();
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            if(node.next[s.charAt(i) - 'a'] != null) {
                node = node.next[s.charAt(i) - 'a'];
            } else {
                node = null;
                break;
            }
        }
        if (node != null) {
            for(String next : node.words) {
                candidate.add(next);
                findSquare(res, candidate, len);
                candidate.remove(candidate.size() - 1);
            }
        }
    }

    private void buildTrie(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            char[] array = word.toCharArray();
            for (char c : array) {
                node.words.add(word);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.words.add(word);
        }
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        List<String> words = new ArrayList<>();
    }
}
