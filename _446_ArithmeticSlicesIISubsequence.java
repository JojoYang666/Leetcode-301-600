package leetcode_301To600;

import java.util.HashMap;

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
public class _446_ArithmeticSlicesIISubsequence {

    /**
     * A sequence of numbers is called arithmetic if it consists of at least three elements and
     * if the difference between any two consecutive elements is the same.

     For example, these are arithmetic sequences:

     1, 3, 5, 7, 9
     7, 7, 7, 7
     3, -1, -5, -9
     The following sequence is not arithmetic.

     1, 1, 2, 5, 7

     A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is
     any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

     A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence
     A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this means that k ≥ 2.

     The function should return the number of arithmetic subsequence slices in the array A.

     The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000.
     The output is guaranteed to be less than 231-1.


     Example:

     Input: [2, 4, 6, 8, 10]

     Output: 7

     Explanation:
     All arithmetic subsequence slices are:
     [2,4,6]
     [4,6,8]
     [6,8,10]
     [2,4,6,8]
     [4,6,8,10]
     [2,4,6,8,10]
     [2,6,10]

     time : O(n^2)
     space : O(n^2)
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        long res = 0;
        HashMap<Integer, Integer>[] map = new HashMap[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long)A[i] - (long)A[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int)delta;
                int sum = map[j].getOrDefault(diff, 0);
                int origin = map[i].getOrDefault(diff, 0);
                map[i].put(diff, origin + sum + 1);
                res += sum;
            }
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 6, 8, 10};
        numberOfArithmeticSlices(nums);
    }
}
