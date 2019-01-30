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
public class _453_MinimumMovestoEqualArrayElements {
    /**
     * 453. Minimum Moves to Equal Array Elements
     * Given a non-empty integer array of size n, find the minimum number of moves required to
     * make all array elements equal, where a move is incrementing n - 1 elements by 1.

     Example:

     Input:
     [1,2,3]

     Output:
     3

     Explanation:
     Only three moves are needed (remember each move increments two elements):

     [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
                  [1,2,2]

     len * (min + k) = sum + k * (len - 1) * 1.
     ==> k = sum - min * len;

     time : O(n)
     space : O(1)


     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        long sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return (int)(sum - min * nums.length);
    }
}
