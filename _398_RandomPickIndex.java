package leetcode_1To300;

import java.util.Random;

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
public class _398_RandomPickIndex {
    /**
     * 398. Random Pick Index
     * Given an array of integers with possible duplicates, randomly output the index of a given target
     * number. You can assume that the given target number must exist in the array.

     Note:
     The array size can be very large. Solution that uses too much extra space will not pass the judge.

     Example:

     int[] nums = new int[] {1,2,3,3,3};
     Solution solution = new Solution(nums);

     // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
     solution.pick(3);

     // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
     solution.pick(1);

     time : O(n);
     * @param nums
     */

    private int[] nums;
    Random rmd;

    public _398_RandomPickIndex(int[] nums) {
        this.nums = nums;
        rmd = new Random();
    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            if (rmd.nextInt(++count) == 0) {
                res = i;
            }
        }
        return res;
    }
}
