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
public class _540_SingleElementinaSortedArray {

    /**
     * Given a sorted array consisting of only integers
     * where every element appears twice except for one element which appears once. 
     * Find this single element that appears only once.

     Example 1:

     Input: [1,1,2,3,3,4,4,8,8]
     Output: 2
     Example 2:

     Input: [3,3,7,7,10,11,11]
     Output: 10

     time : O(logn)
     space : O(1)
     
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length / 2;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[2 * mid] != nums[2 * mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[2 * start];
    }
}
