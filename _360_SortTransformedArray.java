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
public class _360_SortTransformedArray {
    /**
     * 360. Sort Transformed Array
     * Given a sorted array of integers nums and integer values a, b and c.
     * Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.

     The returned array must be in sorted order.

     Expected time complexity: O(n)

     Example:
     nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

     Result: [3, 9, 15, 33]

     nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

     Result: [-23, -5, 1, 7]

     time : O(n)
     space : O(n)

     * @param nums
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int i = a >= 0 ? nums.length - 1 : 0;
        while (start <= end) {
            int startNum = getNum(nums[start], a, b, c);
            int endNum = getNum(nums[end], a, b, c);
            if (a >= 0) {
                if (startNum >= endNum) {
                    res[i--] = startNum;
                    start++;
                } else {
                    res[i--] = endNum;
                    end--;
                }
            } else {
                if (startNum <= endNum) {
                    res[i++] = startNum;
                    start++;
                } else {
                    res[i--] = endNum;
                    end--;
                }
            }
        }
        return res;
    }

    private int getNum(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
