/*
 * 网站地址：cspiration.com
 * 课程：Leetcode Java 版本视频讲解
 * 创作人：Edward Shi
 */

package leetcode_301To600;

import java.util.LinkedList;
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
public class _431_EncodeNaryTreetoBinaryTree {

    /**
     * time : O(n)
     * space : O(n)
     * @param root
     * @return
     */
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode res = new TreeNode(root.val);
        if (root.children.size() > 0) {
            res.left = encode(root.children.get(0));
        }
        TreeNode cur = res.left;
        for (int i = 1; i < root.children.size(); i++) {
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }
        return res;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Node res = new Node(root.val, new LinkedList<>());
        TreeNode cur = root.left;
        while (cur != null) {
            res.children.add(decode(cur));
            cur = cur.right;
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
