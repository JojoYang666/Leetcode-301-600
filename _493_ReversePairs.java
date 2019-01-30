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
public class _493_ReversePairs {

    /**
     * Given an array nums, we call (i, j) 
     * an important reverse pair if i < j and nums[i] > 2*nums[j].

     You need to return the number of important reverse pairs in the given array.

     Example1:

     Input: [1,3,2,3,1]
     Output: 2
     Example2:

     Input: [2,4,3,5,1]
     Output: 3

     time : O(nlogn)
     space : O(n)

     315. Count of Smaller Numbers After Self
     327. Count of Range Sum
     
     */
    public static int reversePairs(int[] nums) {
        return mergeSortHelper(nums, 0, nums.length - 1);
    }

    private static int mergeSortHelper(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + ((right - left) / 2);
        int res = mergeSortHelper(nums, left, mid) + mergeSortHelper(nums, mid + 1, right);

        int i = left, j = mid + 1, k = 0, p = mid + 1;
        int[] merge = new int[right - left + 1];

        while (i <= mid) {
            while (p <= right && nums[i] > 2L * nums[p]) {
                p++;
            }
            res += p - (mid + 1);

            while (j <= right && nums[i] >= nums[j]) {
                merge[k++] = nums[j++];
            }
            merge[k++] = nums[i++];
        }
        while (j <= right) {
            merge[k++] = nums[j++];
        }

        System.arraycopy(merge, 0, nums, left, merge.length);
        return res;
    }

    public static void main(String[] args) {
        reversePairs(new int[]{1,3,2,3,1});
    }
}
