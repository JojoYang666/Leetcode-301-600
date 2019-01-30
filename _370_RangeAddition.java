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
public class _370_RangeAddition {
    /**
     * 370. Range Addition
     * Assume you have an array of length n initialized with all 0's and are given k update operations.

     Each operation is represented as a triplet: [startIndex, endIndex, inc]
     which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

     Return the modified array after all k operations were executed.
     * Example:

     Given:

     length = 5,
     updates = [
     [1,  3,  2],
     [2,  4,  3],
     [0,  2, -2]
     ]

     Output:

     [-2, 0, 3, 5, 3]
     Explanation:

     Initial state:
     [ 0, 0, 0, 0, 0 ]

     After applying operation [1, 3, 2]:
     [ 0, 2, 2, 2, 0 ]

     After applying operation [2, 4, 3]:
     [ 0, 2, 5, 5, 3 ]

     After applying operation [0, 2, -2]:
     [-2, 0, 3, 5, 3 ]

     time : O(K + N);
     space : O(n)


     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];
            res[start] += value;
            if (end + 1 < length) {
                res[end + 1] -= value;
            }
        }
        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
