package leetcode_301To600;

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
public class _421_MaximumXORofTwoNumbersinanArray {

    /**
     * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

     Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

     Could you do this in O(n) runtime?

     Example:

     Input: [3, 10, 5, 25, 2, 8]

     Output: 28

     Explanation: The maximum result is 5 ^ 25 = 28.

     time : O(n)
     space : O(n)

     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        int res = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = res | (1 << i);
            for (int prefix : set) {
                if(set.contains(tmp ^ prefix)) {
                    res = tmp;
                    break;
                }
            }
        }
        return res;
    }
}
