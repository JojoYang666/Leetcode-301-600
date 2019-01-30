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
public class _457_CircularArrayLoop {

    /**
     * You are given an array of positive and negative integers.
     * If a number n at an index is positive, then move forward n steps. Conversely,
     * if it's negative (-n), move backward n steps.
     * Assume the first element of the array is forward next to the last element,
     * and the last element is backward next to the first element.
     * Determine if there is a loop in this array.
     * A loop starts and ends at a particular index with more than 1 element along the loop.
     * The loop must be "forward" or "backward'.

     Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.

     Example 2: Given the array [-1, 2], there is no loop.

     Note: The given array is guaranteed to contain no element "0".

     Can you do it in O(n) time complexity and O(1) space complexity?

     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = getIndex(i, nums);
            while (nums[fast] * nums[i] > 0 && nums[getIndex(fast, nums)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == getIndex(slow, nums)) {
                        break;
                    }
                    return true;
                }
                slow = getIndex(slow, nums);
                fast = getIndex(getIndex(fast, nums), nums);
            }
            slow = i;
            int val = nums[i];
            while (nums[slow] * val > 0) {
                int next = getIndex(slow, nums);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }

    private int getIndex(int i, int[] nums) {
        int len = nums.length;
        return i + nums[i] >= 0 ? (i + nums[i]) % len : len + (i + nums[i]) % len;
    }

}
