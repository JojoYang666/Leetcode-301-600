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
public class _536_ConstructBinaryTreefromString {
    /**
     * You need to construct a binary tree from a string consisting of parenthesis and integers.

     The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

     You always start to construct the left child node of the parent first if it exists.

     Example:

     Input: "4(2(3)(1))(6(5))"
     Output: return the tree root node representing the following tree:

          4
        /   \
       2     6
      / \   /
     3   1 5
     Note:

     There will only be '(', ')', '-' and '0' ~ '9' in the input string.
     An empty tree is represented by "" instead of "()".

     time : O(n)
     space : O(n)

     * @param s
     * @return
     */
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
             int j = i;
             char c = s.charAt(i);
             if (c == ')') {
                 stack.pop();
             } else if (c >= '0' && c <= '9' || c =='-') {
                 while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                     i++;
                 }
                 TreeNode cur = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                 if (!stack.isEmpty()) {
                     TreeNode parent = stack.peek();
                     if (parent.left != null) {
                         parent.right = cur;
                     } else {
                         parent.left = cur;
                     }
                 }
                 stack.push(cur);
             }
        }
        return stack.peek();
    }
}
