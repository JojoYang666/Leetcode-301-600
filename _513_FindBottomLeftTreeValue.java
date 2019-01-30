package leetcode_301To600;

import java.util.LinkedList;
import java.util.Queue;

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
public class _513_FindBottomLeftTreeValue {

    /**
     * Given a binary tree, find the leftmost value in the last row of the tree.

     Example 1:
     Input:

       2
      / \
     1   3

     Output:
     1
     Example 2:
     Input:

         1
        / \
       2   3
      /   / \
     4   5   6
        /
       7

     Output:
     7

     time : O(n);
     space : O(n);
     * @param root
     * @return
     */

    int res = 0;
    int height = 0;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        helper(root, 1);
        return res;
    }

    public void helper(TreeNode root, int depth) {
        if (root == null) return;
        if (height < depth) {
            res = root.val;
            height = depth;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }



    public int findBottomLeftValue2(TreeNode root) {
        if (root == null) return -1;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res = cur.val;
            if (cur.right != null) queue.offer(cur.right);
            if (cur.left != null) queue.offer(cur.left);
        }
        return res;
    }

}
