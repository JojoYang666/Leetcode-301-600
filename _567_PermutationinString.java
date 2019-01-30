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
public class _567_PermutationinString {
    /**
     * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
     * In other words, one of the first string's permutations is the substring of the second string.
     Example 1:

     Input:s1 = "ab" s2 = "eidbaooo"
     Output:True
     Explanation: s2 contains one permutation of s1 ("ba").
     Example 2:

     Input:s1= "ab" s2 = "eidboaoo"
     Output: False

     time : O(n)
     space : O(1)

     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        for (char c : s1.toCharArray()) {
            count[c]++;
        }
        for (int i = 0, j = 0; i < s2.length(); i++) {
            if (--count[s2.charAt(i)] < 0) {
                while (count[s2.charAt(i)] != 0) {
                    count[s2.charAt(j++)]++;
                }
            } else if (i - j + 1 == s1.length()) {
                return true;
            }
        }

        return false;
    }
}
