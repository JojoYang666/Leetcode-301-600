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
public class _301_RemoveInvalidParentheses {
    /**
     * 301. Remove Invalid Parentheses
     * Remove the minimum number of invalid parentheses in order to make the input string valid.
     * Return all possible results.

     Note: The input string may contain letters other than the parentheses ( and ).

     Examples:
     "()())()" -> ["()()()", "(())()"]
     "(a)())()" -> ["(a)()()", "(a())()"]
     ")(" -> [""]
     Credits:
     Special thanks to @hpplayer for adding this problem and creating all test cases.

     time : 不知道
     space : O(n)

     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }
    public void helper(List<String> res, String s, int last_i, int last_j, char[] pair) {
        for (int count = 0, i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) count++;
            if (s.charAt(i) == pair[1]) count--;
            if (count >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j - 1) != pair[1])) {
                    helper(res, s.substring(0, j) + s.substring(j + 1), i, j, pair);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            helper(res, reversed, 0, 0, new char[]{')', '('});
        } else {
            res.add(reversed);
        }
    }
}
