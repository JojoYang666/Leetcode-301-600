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
public class _430_FlattenaMultilevelDoublyLinkedList {

    /**
     * You are given a doubly linked list which in addition to the next and previous pointers,
     * it could have a child pointer, which may or may not point to a separate doubly linked list.
     * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure,
     * as shown in the example below.

     Flatten the list so that all the nodes appear in a single-level, doubly linked list.
     You are given the head of the first level of the list.



     Example:

     Input:
     1---2---3---4---5---6--NULL
             |
             7---8---9---10--NULL
                 |
                 11--12--NULL

     Output:
     1-2-3-7-8-11-12-9-10-4-5-6-NULL

     time : O(n)
     space : O(n)

     * @param head
     * @return
     */
    public Node flatten(Node head) {
        Node node = head;
        while (node != null) {
            if (node.child != null) {
                Node right = node.next;

                node.next = flatten(node.child);
                node.next.prev = node;
                node.child = null;
                while (node.next != null) {
                    node = node.next;
                }

                if (right != null) {
                    node.next = right;
                    node.next.prev = node;
                }
            }
            node = node.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };
}
