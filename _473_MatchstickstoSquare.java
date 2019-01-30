package leetcode_301To600;

import live.Array;

import java.util.Arrays;

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
public class _473_MatchstickstoSquare {


    /**
     * Example 1:

     Input: [1,1,2,2,2]
     Output: true

     Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
     Example 2:

     Input: [3,3,3,3,4]
     Output: false

     Explanation: You cannot find a way to form a square with all the matchsticks.

     time : O(4^n)
     space : O(n)

     * @param nums
     * @return
     */
    public boolean makesquare(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        return helper(nums, nums.length - 1, sum / 4, new int[4]);
    }

    public boolean helper(int[] nums, int index, int side, int[] sides) {
        if (index < 0) {
            return (sides[0] == side && sides[1] == side && sides[2] == side && sides[3] == side);
        }
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] + nums[index] > side) {
                continue;
            }
            sides[i] += nums[index];
            if (helper(nums, index - 1, side, sides)) {
                return true;
            }
            sides[i] -= nums[index];
        }
        return false;
    }
}
