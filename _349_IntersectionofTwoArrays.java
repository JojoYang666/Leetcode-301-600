package leetcode_1To300;

import java.util.Arrays;
import java.util.HashSet;

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
public class _349_IntersectionofTwoArrays {
    /**
     * 349. Intersection of Two Arrays
     * Given two arrays, write a function to compute their intersection.

     Example:
     Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

     Note:
     Each element in the result must be unique.
     The result can be in any order.

     time : O(n);
     space : O(n);

     * @param nums1
     * @param nums2
     * @return
     */

    // binary search time : O(nlogn) space : O(n)
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int k = 0;
        int[] res = new int[set.size()];
        for (Integer num : set) {
            res[k++] = num;
        }
        return res;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target || nums[end] == target) return true;
        return false;
    }

    // Arrays.sort time : O(nlogn) space : O(n);
    public static int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int k = 0;
        int[] res = new int[set.size()];
        for (Integer num : set) {
            res[k++] = num;
        }
        return res;
    }

    // time : O(n) space : O(n);
    public static int[] intersection3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ret = new HashSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }
        for (Integer num : nums2) {
            if (set.contains(num)) {
                ret.add(num);
            }
        }
        int k = 0;
        int[] res = new int[ret.size()];
        for (Integer num : ret) {
            res[k++] = num;
        }
        return res;
    }
}
