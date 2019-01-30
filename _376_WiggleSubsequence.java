package leetcode_1To300;

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
public class _376_WiggleSubsequence {

    /**
     * 376. Wiggle Subsequence
     * Examples:
     Input: [1,7,4,9,2,5]
     Output: 6
     The entire sequence is a wiggle sequence.

     Input: [1,17,5,10,13,15,10,5,16,8]
     Output: 7
     There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

     Input: [1,2,3,4,5,6,7,8,9]
     Output: 2

     dp up[] down[]

     Input: [1,7,4,9,2,5]

     up[1,2,2]
     down[1,1,3]

     time : O(n)
     space : O(n) / O(1)

     * @param nums
     * @return
     */

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[ i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }

    public int wiggleMaxLength2(int[] nums) {
        if (nums.length == 0) return 0;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
