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
public class _563_BinaryTreeTilt {
    /**
     * 563. Binary Tree Tilt
     * Given a binary tree, return the tilt of the whole tree.

     The tilt of a tree node is defined as the absolute difference between the sum of all
     left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

     The tilt of the whole tree is defined as the sum of all nodes' tilt.

     Example:
     Input:
          1
        /   \
       2     3
      / \   / \
     4   5 6   7
     Output: 1
     Explanation:
     Tilt of node 4 : 0
     Tilt of node 5 : 0
     Tilt of node 6 : 0
     Tilt of node 7 : 0
     Tilt of node 2 : |5-4| = 1
     Tilt of node 3 : |7-6| = 1
     Tilt of node 1 : |2+4+5-3-6-7| = 5
     Tilt of binary tree : 1 + 1 + 5 = 7

     time : O(n)
     space : O(n)

     * @param root
     * @return
     */
    int res = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }
}
