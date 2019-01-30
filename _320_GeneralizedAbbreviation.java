package leetcode_1To300;

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
public class _320_GeneralizedAbbreviation {
    /**
     * 320. Generalized Abbreviation
     * Example:
     Given word = "word", return the following list (order does not matter):
     ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

     ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]

     time : O(2^n)
     space : O(n) (不确定)

     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, 0, "", 0);
        return res;
    }

    public void helper(List<String> res, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) cur += count;
            res.add(cur);
        } else {
            helper(res, word, pos + 1, cur, count + 1);
            helper(res, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }

    }

}
