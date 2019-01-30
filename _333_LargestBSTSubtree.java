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
public class _333_LargestBSTSubtree {
    /**
     * 333. Largest BST Subtree
     * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
     * where largest means subtree with largest number of nodes in it.

     Note:
     A subtree must include all of its descendants.
     Here's an example:
         10
        / \
       5  15
      / \   \
     1   8   7
     /
     null
     The Largest BST Subtree in this case is the highlighted one.
     The return value is the subtree's size, which is 3.

     1, postorder
     2, BST
     3, decide BST

     1 : 1,1,1
     8 : 1,8,8
     5 : 3,1,8
     7 : 1,7,7
     15 : -1,0,0

     time : O(n)
     space : O(n)

     */

    int res = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private SearchNode helper(TreeNode root) {
        if (root == null) {
            return new SearchNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        SearchNode left = helper(root.left);
        SearchNode right = helper(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new SearchNode(-1, 0, 0);
        }
        int size = left.size + right.size + 1;
        res = Math.max(size, res);
        return new SearchNode(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }

    class SearchNode {
        int size;
        int lower;
        int upper;

        SearchNode(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
}
