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
public class _366_FindLeavesofBinaryTree {
    /**
     * 366. Find Leaves of Binary Tree
     * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves,
     * repeat until the tree is empty.

     Example:
     Given binary tree
         1
        / \
       2   3
      / \
     4   5   0
     /
     null   -1
     Returns [4, 5, 3], [2], [1].


     Explanation:
     1. Removing the leaves [4, 5, 3] would result in this tree:

       1
      /
     2
     2. Now removing the leaf [2] would result in this tree:

     1
     3. Now removing the leaf [1] would result in the empty tree:

     []
     Returns [4, 5, 3], [2], [1].

     time : O(n)
     space : O(n)

     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null) return -1;
        int left = helper(res, root.left);
        int right = helper(res, root.right);
        int level = Math.max(left, right) + 1;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }
}
