package leetcode_301To600;

import java.util.Collections;
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
public class _480_SlidingWindowMedian {

    /**
     * Median is the middle value in an ordered integer list. If the size of the list is even,
     * there is no middle value. So the median is the mean of the two middle value.

     Examples:
     [2,3,4] , the median is 3

     [2,3], the median is (2 + 3) / 2 = 2.5

     Given an array nums, there is a sliding window of size k which is moving
     from the very left of the array to the very right. You can only see the k numbers in the window.
     Each time the sliding window moves right by one position.
     Your job is to output the median array for each window in the original array.

     For example,
     Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

     Window position                Median
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       1
     1 [3  -1  -3] 5  3  6  7       -1
     1  3 [-1  -3  5] 3  6  7       -1
     1  3  -1 [-3  5  3] 6  7       3
     1  3  -1  -3 [5  3  6] 7       5
     1  3  -1  -3  5 [3  6  7]      6
     Therefore, return the median sliding window as [1,-1,-1,3,5,6].

     Note:
     You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.

     time : O(nk)
     space ; O(k)

     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (left.size() <= right.size()) {
                right.add(nums[i]);
                left.add(right.remove());
            } else {
                left.add(nums[i]);
                right.add(left.remove());
            }
            if (left.size() + right.size() == k) {
                double median;
                if (left.size() == right.size()) {
                    median = (double)((long)left.peek() + (long)right.peek()) / 2;
                } else {
                    median = (double)left.peek();
                }
                int start = i - k + 1;
                res[start] = median;
                if (!left.remove(nums[start])) {
                    right.remove(nums[start]);
                }
            }
        }
        return res;
    }
}
