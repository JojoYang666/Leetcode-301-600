package leetcode_1To300;

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
public class _395_LongestSubstringwithAtLeastKRepeatingCharacters {
    /**
     * 395. Longest Substring with At Least K Repeating Characters
     * Find the length of the longest substring T of a given string (consists of lowercase letters only)
     * such that every character in T appears no less than k times.

     Example 1:

     Input:
     s = "aaabb", k = 3

     Output:
     3

     The longest substring is "aaa", as 'a' is repeated 3 times.
     Example 2:

     Input:
     s = "ababbc", k = 2

     Output:
     5

     The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.


     * @param s
     * @param k
     * @return
     */

    // time : O(n) space : O(1)
    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            res = Math.max(res, helper(s, k, numUniqueTarget));
        }
        return res;
    }

    private int helper(String s, int k, int numUniqueTareget) {
        int[] count = new int[128];
        int start = 0, end = 0;
        int numUnqiue = 0, numNoLessThanK = 0;
        int res = 0;

        while (end < s.length()) {
            if (count[s.charAt(end)]++ == 0) numUnqiue++;
            if (count[s.charAt(end++)] == k) numNoLessThanK++;

            while (numUnqiue > numUniqueTareget) {
                if (count[s.charAt(start)]-- == k) numNoLessThanK--;
                if (count[s.charAt(start++)] == 0) numUnqiue--;
            }
            if (numUnqiue == numUniqueTareget && numUnqiue == numNoLessThanK) {
                res = Math.max(end - start, res);
            }
        }
        return res;
    }
}
