package leetcode_301To600;

import java.util.HashMap;
import java.util.LinkedHashSet;

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
public class _432_AllOoneDataStructure {

    /**
     * Implement a data structure supporting the following operations:

     Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
     Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1.
                If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
     GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
     GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
     Challenge: Perform all these in O(1) time complexity.

     time : O(1)
     space : O(n)

     */
    /** Initialize your data structure here. */


    class Node {
        int val;
        LinkedHashSet<String> keys;
        Node pre;
        Node next;
        public Node(int val) {
            this.val = val;
            this.keys = new LinkedHashSet<>();
        }
    }

    HashMap<String, Node> map;
    Node head;
    Node tail;

    public _432_AllOoneDataStructure() {
        this.map = new HashMap<>();
        this.head = new Node(-1);
        this.tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    public void addNext(Node cur, Node next) {
        next.pre = cur;
        next.next = cur.next;
        cur.next.pre = next;
        cur.next = next;
    }

    public void addPre(Node cur, Node pre) {
        pre.next = cur;
        pre.pre = cur.pre;
        cur.pre.next = pre;
        cur.pre = pre;
    }

    public void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node curNode = map.get(key);
            int curVal = curNode.val;
            Node nextNode;
            if (curNode.next.val == curVal + 1) {
                nextNode = curNode.next;
                nextNode.keys.add(key);
            } else {
                nextNode = new Node(curVal + 1);
                nextNode.keys.add(key);
                addNext(curNode, nextNode);
            }
            curNode.keys.remove(key);
            if (curNode.keys.size() == 0) {
                removeNode(curNode);
            }
            map.put(key, nextNode);
        } else {
            if (head.next.val == 1) {
                head.next.keys.add(key);
                map.put(key, head.next);
            } else {
                Node cur = new Node(1);
                cur.keys.add(key);
                addNext(head, cur);
                map.put(key, cur);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
            Node curNode = map.get(key);
            int curVal = curNode.val;
            if (curVal == 1) {
                curNode.keys.remove(key);
                if (curNode.keys.size() == 0) {
                    removeNode(curNode);
                }
                map.remove(key);
            } else {
                Node preNode;
                if (curNode.pre.val == curVal - 1) {
                    preNode = curNode.pre;
                    preNode.keys.add(key);
                } else {
                    preNode = new Node(curVal - 1);
                    preNode.keys.add(key);
                    addPre(curNode, preNode);
                }
                curNode.keys.remove(key);
                if (curNode.keys.size() == 0) {
                    removeNode(curNode);
                }
                map.put(key, preNode);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.pre == head) {
            return "";
        } else {
            return tail.pre.keys.iterator().next();
        }
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        } else {
            return head.next.keys.iterator().next();
        }
    }
}
