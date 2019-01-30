package leetcode_1To300;

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
public class _339_NestedListWeightSum {
    /**
     * 339. Nested List Weight Sum
     * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

     Each element is either an integer, or a list -- whose elements may also be integers or other lists.

     Example 1:
     Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

     Example 2:
     Given the list [1,[4,[6]]], return 27.
     (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)


     time : O(n)
     space : O(n);
     * @param nestedList
     * @return
     */


    // DFS
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                res += nest.getInteger() * depth;
            } else {
                res += helper(nest.getList(), depth + 1);
            }
        }
        return res;
    }

    // BFS
    public int depthSum2(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int depth = 1;
        int res = 0;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nest = queue.poll();
                if (nest.isInteger()) {
                    res += nest.getInteger() * depth;
                } else {
                    queue.addAll(nest.getList());
                }
            }
            depth++;
        }
        return res;
    }


    public int depthSum3(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int depth = 1;
        int res = 0;
        while (nestedList.size() != 0) {
            List<NestedInteger> nextList = new LinkedList<>();
            for (NestedInteger nest : nestedList) {
                if (nest.isInteger()) {
                    res += nest.getInteger() * depth;
                } else {
                    nextList.addAll(nest.getList());
                }
            }
            depth++;
            nestedList = nextList;
        }
        return res;
    }
}
