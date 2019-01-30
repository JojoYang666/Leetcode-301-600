package leetcode_301To600;

import java.util.Arrays;
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
public class _503_NextGreaterElementII {

    /**
     * Given a circular array (the next element of the last element is the first element of the array),
     * print the Next Greater Number for every element.
     * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
     * which means you could search circularly to find its next greater number. If it doesn't exist,
     * output -1 for this number.

     Example 1:

     Input: [1,2,1]
     Output: [2,-1,2]
     Explanation: The first 1's next greater number is 2;
     The number 2 can't find next greater number;
     The second 1's next greater number needs to search circularly, which is also 2.

     time : O(n)
     space : O(n)
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len * 2; i++) {
            int num = nums[i % len];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < len) {
                stack.push(i);
            }
        }

        return res;
    }
}
