package leetcode_301To600;

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
public class _501_FindModeinBinarySearchTree {

    /**
     * Given a binary search tree (BST) with duplicates, find all the mode(s)
     * (the most frequently occurred element) in the given BST.

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than or equal to the node's key.
     The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
     Both the left and right subtrees must also be binary search trees.


     For example:
     Given BST [1,null,2,2],

     1
      \
       2
      /
     2


     return [2].

     time : O(n)
     space : O(h)

     */

    int count = 1;
    int max = 0;
    Integer pre = null;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        if (pre != null) {
            if (root.val == pre) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        pre = root.val;
        helper(root.right, list);
    }

}
