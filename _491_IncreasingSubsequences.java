package leetcode_301To600;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
public class _491_IncreasingSubsequences {
    /**
     * Given an integer array, your task is to find all the different possible increasing
     * subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

     Example:
     Input: [4, 6, 7, 7]
     Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]


     time : O(2^n);
     space : O(n);
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length == 0) return new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        List ret = new ArrayList(res);
        return ret;
    }

    public void helper(HashSet<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                helper(res, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
