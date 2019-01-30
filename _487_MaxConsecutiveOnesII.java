package leetcode_301To600;

import java.util.LinkedList;
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
public class _487_MaxConsecutiveOnesII {

    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array 
     * if you can flip at most one 0.

     Example 1:

     Input: [1,0,1,1,0]
     Output: 4
     Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
     After flipping, the maximum number of consecutive 1s is 4.

     time : O(n)
     space : O(n)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int k = 1;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0, l = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                queue.offer(i);
            }
            if (queue.size() > k) {
                l = queue.poll() + 1;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int res = 0;
        int queue = -1;

        for (int i = 0, l = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                l = queue + 1;
                queue = i;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}
