package leetcode_301To600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
public class _425_WordSquares {

    /**
     * For example, the word sequence ["ball","area","lead","lady"] forms
     * a word square because each word reads the same both horizontally and vertically.

     b a l l
     a r e a
     l e a d
     l a d y
     Note:

     There are at least 1 and at most 1000 words.
     All words will have the exact same length.
     Word length is at least 1 and at most 5.
     Each word contains only lowercase English alphabet a-z.
     Example 1:

     Input:
     ["area","lead","wall","lady","ball"]

     Output:
     [
     [ "wall",
     "area",
     "lead",
     "lady"
     ],
     [ "ball",
     "area",
     "lead",
     "lady"
     ]
     ]

     Explanation:
     The output consists of two word squares.
     The order of output does not matter (just the order of words in each word square matters).
     Example 2:

     Input:
     ["abat","baba","atan","atal"]

     Output:
     [
     [ "baba",
     "abat",
     "baba",
     "atan"
     ],
     [ "baba",
     "abat",
     "baba",
     "atal"
     ]
     ]

     Explanation:
     The output consists of two word squares.
     The order of output does not matter (just the order of words in each word square matters).

     time : O(n!) 不确定
     space : O(n * max(len)) 不确定

     area
     a : area
     ar : area
     are : area
     area : area

     * @param words
     * @return
     */

    public List<List<String>> wordSquares(String[] words) {
        HashMap<String, HashSet<String>> prefix = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String s = word.substring(0, i);
                prefix.putIfAbsent(s, new HashSet<>());
                prefix.get(s).add(word);
            }
        }

        List<List<String>> res = new ArrayList<>();
        List<String> candidate;
        for (String word : words) {
            candidate = new ArrayList<>();
            candidate.add(word);
            dfs(res, candidate, 1, words[0].length(), prefix);
        }
        return res;
    }

    private void dfs(List<List<String>> res, List<String> candidate, int pos, int len,
                     HashMap<String, HashSet<String>> prefix) {
        if (pos == len) {
            res.add(new ArrayList<>(candidate));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String cand : candidate) {
            sb.append(cand.charAt(pos));
        }
        if (!prefix.containsKey(sb.toString())) {
            return;
        }
        for (String next : prefix.get(sb.toString())) {
            candidate.add(next);
            dfs(res, candidate, pos + 1, len, prefix);
            candidate.remove(candidate.size() - 1);
        }
    }

}
