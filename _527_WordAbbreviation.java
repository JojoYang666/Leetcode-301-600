package leetcode_301To600;

import java.util.Arrays;
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
public class _527_WordAbbreviation {

    /**
     * Given an array of n distinct non-empty strings, you need to generate minimal
     * possible abbreviations for every word following rules below.

     Begin with the first character and then the number of characters abbreviated,
     which followed by the last character.
     If there are any conflict, that is more than one words share the same abbreviation,
     a longer prefix is used instead of only the first character until
     making the map from word to abbreviation become unique. In other words,
     a final abbreviation cannot map to more than one original words.
     If the abbreviation doesn't make the word shorter, then keep it as original.
     Example:

     Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
     Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]

     time : O(m^2*n^2)
     space : O(n)

     * @param dict
     * @return
     */
    public List<String> wordsAbbreviation(List<String> dict) {
        int n = dict.size();
        String[] res = new String[n];
        int[] prefix = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = abbr(dict.get(i), 0);
        }

        for (int i = 0; i < n; i++) {
            while (true) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = i + 1; j < n; j++) {
                    if (res[i].equals(res[j])) {
                        set.add(j);
                    }
                }
                if (set.isEmpty()) break;
                set.add(i);
                for (int k : set) {
                    res[k] = abbr(dict.get(k), ++prefix[k]);
                }
            }
        }

        return Arrays.asList(res);
    }

    private String abbr(String word, int i) {
        int n = word.length();
        if (n - i <= 3) {
            return word;
        }
        return word.substring(0, i + 1) + (n - i - 2) + word.charAt(n - 1);
    }

}
