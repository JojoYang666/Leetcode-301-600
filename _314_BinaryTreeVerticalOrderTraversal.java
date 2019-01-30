package leetcode_1To300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
public class _314_BinaryTreeVerticalOrderTraversal {
    /**
     * 314. Binary Tree Vertical Order Traversal
     * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

     If two nodes are in the same row and column, the order should be from left to right.

     Examples:

     Given binary tree [3,9,20,null,null,15,7],
         3
        / \
       9  20
          / \
        15  7

              |
      . _ * _ * _ 0 _ . _ *
     -2  -1   0   1   2   3

     return its vertical order traversal as:
     [
     [9],
     [3,15],
     [20],
     [7]
     ]
     Given binary tree [3,9,8,4,0,1,7],
          3
         / \
       9    8
      / \  / \
     4  0 1   7
     -2  0   2

     return its vertical order traversal as:
     [
     [4],
     [9],
     [3,0,1],
     [8],
     [7]
     ]

     1, dfs max min
     2, bfs

     time : O(n)
     space : O(n)


     */
    private int min = 0;
    private int max = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, 0);
        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<>());
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        index.offer(-min);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int idx = index.poll();
            res.get(idx).add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                index.offer(idx - 1);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                index.offer(idx + 1);
            }
        }
        return res;
    }

    private void helper(TreeNode root, int idx) {
        if (root == null) return;
        min = Math.min(min, idx);
        max = Math.max(max, idx);
        helper(root.left, idx - 1);
        helper(root.right, idx + 1);
    }
}
