package leetcode_301To600;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

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
public class _414_ThirdMaximumNumber {
    /**
     * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

     Example 1:
     Input: [3, 2, 1]

     Output: 1

     Explanation: The third maximum is 1.
     Example 2:
     Input: [1, 2]

     Output: 2

     Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     Example 3:
     Input: [2, 2, 3, 1]

     Output: 1

     Explanation: Note that the third maximum here means the third maximum distinct number.
     Both numbers with value 2 are both considered as second maximum.

     time : O(n)
     space : O(1)


     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer num : nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }

    /**
     * time : O(n)
     * space : O(1)
     *
     * @param nums
     * @return
     */

    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)) {
                priorityQueue.offer(num);
                if (priorityQueue.size() > 3) priorityQueue.poll();
            }
        }
        if (priorityQueue.size() == 2) priorityQueue.poll();
        return priorityQueue.peek();
    }

}
