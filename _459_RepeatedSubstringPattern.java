package leetcode_301To600;

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
public class _459_RepeatedSubstringPattern {

    /**
     * Given a non-empty string check if it can be constructed by taking a substring of it
     * and appending multiple copies of the substring together.
     * You may assume the given string consists of lowercase English letters only and
     * its length will not exceed 10000.



     Example 1:

     Input: "abab"
     Output: True
     Explanation: It's the substring "ab" twice.
     Example 2:

     Input: "aba"
     Output: False

     time : O(m * n)
     space : O(n)
     * @param str
     * @return
     */
    public boolean repeatedSubstringPattern(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }

    /**
     * time : O(n^2)
     * space : O(n)
     * @param str
     * @return
     */
    public boolean repeatedSubstringPattern2(String str) {
        int len = str.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                int num = len / i;
                String sub = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    sb.append(sub);
                }
                if (sb.toString().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
