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
public class  _467_UniqueSubstringsinWraparoundString {

    /**
     * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
     * so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

     Now we have another string p. Your job is to find out how many unique non-empty substrings of p
     are present in s. In particular, your input is the string p and you need to output the number
     of different non-empty substrings of p in the string s.

     Note: p consists of only lowercase English letters and the size of p might be over 10000.

     Example 1:

     Input: "a"
     Output: 1

     Explanation: Only the substring "a" of string "a" is in the string s.
     Example 2:

     Input: "cac"
     Output: 2
     Explanation: There are two substrings "a", "c" of string "cac" in the string s.
     Example 3:

     Input: "zab"
     Output: 6
     Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.

     time : O(n)
     space : O(1)

     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int curMax = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1) || (p.charAt(i - 1) - p.charAt(i) == 25)) {
                curMax++;
            } else {
                curMax = 1;
            }
            count[p.charAt(i) - 'a'] = Math.max(curMax, count[p.charAt(i) - 'a']);
        }
        int res = 0;
        for (int num : count) {
            res += num;
        }
        return res;
    }
}
