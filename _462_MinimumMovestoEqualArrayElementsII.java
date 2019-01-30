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
public class _462_MinimumMovestoEqualArrayElementsII {
    /**
     * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
     * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

     You may assume the array's length is at most 10,000.

     Example:

     Input:
     [1,2,3]

     Output:
     2

     Explanation:
     Only two moves are needed (remember each move increments or decrements one element):

     [1,2,3]  =>  [2,2,3]  =>  [2,2,2]

     * @param nums
     * @return
     */
    /**
     * time : O(nlogn)
     * space : O(1)
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int res = 0;
        while (i < j) {
            res += nums[j--] - nums[i++];
        }
        return res;
    }

    /**
     * time : O(n) O(n ^ 2)
     * space : O(1)
     * @param nums
     * @return
     */
    public int minMoves22(int[] nums) {
        int res = 0;
        int median = findKthLargest(nums, nums.length / 2 + 1);

        for (int num : nums) {
            res += Math.abs(median - num);
        }
        return res;
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
