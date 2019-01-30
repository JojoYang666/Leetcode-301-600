package leetcode_301To600;

import java.util.ArrayList;
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
public class _500_KeyboardRow {

    /**
     * time : O(words.length * max(word.length))
     * space : O(n)
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {

        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        HashMap<Character, Integer> keyboard = new HashMap<>();

        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                keyboard.put(c, i);
            }
        }

        List<String> res = new ArrayList<>();

        for (String word : words) {
            char[] letters = word.toLowerCase().toCharArray();

            boolean sameRow = true;
            int index = keyboard.get(letters[0]);
            for (char c : letters) {
                if (index != keyboard.get(c)) {
                    sameRow = false;
                    break;
                }
            }
            if (sameRow) {
                res.add(word);
            }
        }

        return res.stream().toArray(String[]::new);
    }
}
