package leetcode_301To600;

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
public class _422_ValidWordSquare {

    /**
     * Example 1:

     Input:
     [
     "abcd",
     "bnrt",
     "crmy",
     "dtye"
     ]

     Output:
     true

     Explanation:
     The first row and first column both read "abcd".
     The second row and second column both read "bnrt".
     The third row and third column both read "crmy".
     The fourth row and fourth column both read "dtye".

     Therefore, it is a valid word square.
     Example 2:

     Input:
     [
     "abcd",
     "bnrt",
     "crm",
     "dt"
     ]

     Output:
     true

     Explanation:
     The first row and first column both read "abcd".
     The second row and second column both read "bnrt".
     The third row and third column both read "crm".
     The fourth row and fourth column both read "dt".

     Therefore, it is a valid word square.

     time : O(n * word.length(max))
     space : O(1)
     * @param words
     * @return
     */
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
             for (int j = 0; j < words.get(i).length(); j++) {
                 if (j >= words.size() || i >= words.get(j).length()) {
                     return false;
                 }
                 if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                     return false;
                 }
             }
        }
        return true;
    }
}
