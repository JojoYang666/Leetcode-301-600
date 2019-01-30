
/*
 * 网站地址：cspiration.com
 * 课程：Leetcode Java 版本视频讲解
 * 创作人：Edward Shi
 */

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
public class _451_SortCharactersByFrequency {
    /**
     * Given a string, sort it in decreasing order based on the frequency of characters.

     Example 1:

     Input:
     "tree"

     Output:
     "eert"

     Explanation:
     'e' appears twice while 'r' and 't' both appear once.
     So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

     思路：和 347 一样

     * time : O(n)
     * space : O(n)
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new List[s.length() + 1];
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < map.get(c); j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
