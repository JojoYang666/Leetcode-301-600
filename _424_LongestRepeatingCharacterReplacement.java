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
public class _424_LongestRepeatingCharacterReplacement {

    /**
     * Given a string that consists of only uppercase English letters,
     * you can replace any letter in the string with another letter at most k times.
     * Find the length of a longest substring containing all repeating letters
     * you can get after performing the above operations.

     Note:
     Both the string's length and k will not exceed 104.

     Example 1:

     Input:
     s = "ABAB", k = 2

     Output:
     4

     Explanation:
     Replace the two 'A's with two 'B's or vice versa.
     Example 2:

     Input:
     s = "AABABBA", k = 1

     Output:
     4

     Explanation:
     Replace the one 'A' in the middle with 'B' and form "AABBBBA".
     The substring "BBBB" has the longest repeating letters, which is 4.

     time : O(n)
     space : O(1)

     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0;
        int res = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, ++count[s.charAt(i) - 'A']);
            while (i - start + 1 - max > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
