package leetcode_301To600;

import java.util.Stack;

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
public class _439_TernaryExpressionParser {
    /**
     * Given a string representing arbitrarily nested ternary expressions,
     * calculate the result of the expression. You can always assume
     * that the given expression is valid and only consists of digits 0-9, ?, :,
     * T and F (T and F represent True and False respectively).

     Note:

     The length of the given string is ≤ 10000.
     Each number will contain only one digit.
     The conditional expressions group right-to-left (as usual in most languages).
     The condition will always be either T or F. That is, the condition will never be a digit.
     The result of the expression will always evaluate to either a digit 0-9, T or F.
     Example 1:

     Input: "T?2:3"

     Output: "2"

     Explanation: If true, then result is 2; otherwise result is 3.
     Example 2:

     Input: "F?1:T?4:5"

     Output: "4"

     Explanation: The conditional expressions group right-to-left. Using parenthesis,
     it is read/evaluated as:

     "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
     -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
     -> "4"                                    -> "4"

     time : O(n)
     space : O(n)

     * @param expression
     * @return
     */
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char first = stack.pop();
                stack.pop();
                char second = stack.pop();
                if (c == 'T') {
                    stack.push(first);
                } else {
                    stack.push(second);
                }
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack.peek());
    }
}
