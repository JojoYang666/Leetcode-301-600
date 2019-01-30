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
public class _331_VerifyPreorderSerializationofaBinaryTree {
    /**
     * 331. Verify Preorder Serialization of a Binary Tree
     * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

          _9_
         /   \
        3     2
       / \   / \
      4   1  #  6
     / \ / \   / \
     # # # #   # #

     For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

     Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

     Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

     You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

     Example 1:
     "9,3,4,#,#,1,#,#,2,#,6,#,#"
     Return true

     Example 2:
     "1,#"
     Return false

     Example 3:
     "9,#,#,1"
     Return false

     all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
     all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).

     diff = outdegree - indegree

     time : O(n)
     space : O(n)

     * @param preorder
     * @return
     */

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}
