package leetcode_1To300;

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
public class _385_MiniParser {
    /**
     * 385. Mini Parser
     * Given a nested list of integers represented as a string, implement a parser to deserialize it.

     Each element is either an integer, or a list -- whose elements may also be integers or other lists.

     Note: You may assume that the string is well-formed:

     String is non-empty.
     String does not contain white spaces.
     String contains only digits 0-9, [, - ,, ].
     Example 1:

     Given s = "324",

     You should return a NestedInteger object which contains a single integer 324.
     Example 2:

     Given s = "[123,[456,[789]]]",

     Return a NestedInteger object containing a nested list with 2 elements:

     1. An integer containing value 123.
     2. A nested list containing two elements:
     i.  An integer containing value 456.
     ii. A nested list with one element:
     a. An integer containing value 789.

     StackTest : [: push
            , ] : pop + Integer
            number : s.substring valueOf

     s = "[123,[456,[789]]]"

     res : [123,[456,[789]]]
     stack:  123   [456,[789]]


     [123,[]]

     time : O(n)
     space : O(n)





     * @param s
     * @return
     */
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.valueOf(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger res = new NestedInteger();
        stack.push(res);
        int start = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                NestedInteger nestedInteger = new NestedInteger();
                stack.peek().add(nestedInteger);
                stack.push(nestedInteger);
                start = i + 1;
            } else if (c == ',' || c == ']') {
                if (i > start) {
                    Integer val = Integer.valueOf(s.substring(start, i));
                    stack.peek().add(new NestedInteger(val));
                }
                start = i + 1;
                if (c == ']') {
                    stack.pop();
                }
            }
        }
        return res;
    }
}
