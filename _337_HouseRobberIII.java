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
public class _337_HouseRobberIII {
    /**
     * 337. House Robber III
     * Example 1:
       3  red
      / \
     2   3
      \   \
       3   1  red
     Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     Example 2:
         3
        / \
       4   5  red
      / \   \
     1   3   1
     Maximum amount of money the thief can rob = 4 + 5 = 9.

     time : O(n)
     space : O(n)
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}
