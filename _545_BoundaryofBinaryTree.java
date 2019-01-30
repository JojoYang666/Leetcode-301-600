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
public class _545_BoundaryofBinaryTree {

    /**
     * Given a binary tree, return the values of its boundary in anti-clockwise
     * direction starting from root. Boundary includes left boundary,
     * leaves, and right boundary in order without duplicate res.

     Left boundary is defined as the path from root to the left-most node. Right boundary
     is defined as the path from root to the right-most node.
     If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary.
     Note this definition only applies to the input binary tree, and not applies to any subtrees.

     The left-most node is defined as a leaf node you could reach when you always firstly travel
     to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

     The right-most node is also defined by the same way with left and right exchanged.

     Example 1

     Input:
     1
      \
       2
      / \
     3   4

     Ouput:
     [1, 3, 4, 2]

     Explanation:
     The root doesn't have left subtree, so the root itself is left boundary.
     The leaves are node 3 and 4.
     The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output
     reversed right boundary.
     So order them in anti-clockwise without duplicates and we have [1,3,4,2].
     Example 2

     Input:
          ____1_____
         /          \
        2            3
       / \          /
      4   5        6
         / \      / \
        7   8    9  10

     Ouput:
     [1,2,4,7,8,9,10,6,3]

     Explanation:
     The left boundary are node 1,2,4. (4 is the left-most node according to definition)
     The leaves are node 4,7,8,9,10.
     The right boundary are node 1,3,6,10. (10 is the right-most node).
     So order them in anti-clockwise without duplicate res we have [1,2,4,7,8,9,10,6,3].

     time : O(n)
     space : O(h)

     */

    List<Integer> res = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return res;
        }

        res.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return res;
    }

    public void leftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        res.add(root.val);
        if (root.left == null) {
            leftBoundary(root.right);
        } else {
            leftBoundary(root.left);
        }
    }

    public void rightBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right == null) {
            rightBoundary(root.left);
        } else {
            rightBoundary(root.right);
        }
        res.add(root.val);
    }

    public void leaves(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }

}
