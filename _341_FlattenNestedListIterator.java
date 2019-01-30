package leetcode_1To300;

import java.util.List;
import java.util.Stack;

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
public class _341_FlattenNestedListIterator {
    /**
     * 341. Flatten Nested List Iterator
     * Given a nested list of integers, implement an iterator to flatten it.

     Each element is either an integer, or a list -- whose elements may also be integers or other lists.

     Example 1:
     Given the list [[1,1],2,[1,1]],

     By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

     Example 2:
     Given the list [1,[4,[6]]],

     By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

     time : O(n)
     space : O(n)

     */

    Stack<NestedInteger> stack;

    public _341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    //@Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    //@Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger cur = stack.peek();
            if (cur.isInteger()) {
                return true;
            }
            stack.pop();
            for (int i = cur.getList().size() - 1; i >= 0; i--) {
                stack.push(cur.getList().get(i));
            }
        }
        return false;
    }

}
