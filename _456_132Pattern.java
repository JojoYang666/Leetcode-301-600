package leetcode_301To600;

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
public class _456_132Pattern {

    /**
     * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence
     * ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that
     * takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

     Note: n will be less than 15,000.

     Example 1:

     Input: [1, 2, 3, 4]

     Output: False

     Explanation: There is no 132 pattern in the sequence.
     Example 2:

     Input: [3, 1, 4, 2]

     Output: True

     Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
     Example 3:

     Input: [-1, 3, 2, 0]

     Output: True

     Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

     time : O(n)
     space : O(n)

     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int mid = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < mid) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    mid = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
