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
public class _402_RemoveKDigits {

    /**
     * Given a non-negative integer num represented as a string,
     * remove k digits from the number so that the new number is the smallest possible.

     Note:

     The length of num is less than 10002 and will be ≥ k.
     The given num does not contain any leading zero.
     Example 1:

     Input: num = "1432219", k = 3
     Output: "1219"
     Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
     Example 2:

     Input: num = "10200", k = 1
     Output: "200"
     Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
     Example 3:

     Input: num = "10", k = 2
     Output: "0"
     Explanation: Remove all the digits from the number and it is left with nothing which is 0.

     time : O(n)
     space : O(n)


     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        int res = 0;
        while (res < sb.length() && sb.charAt(res) == '0') {
            res++;
        }
        return res == sb.length() ? "0" : sb.substring(res);
    }
}
