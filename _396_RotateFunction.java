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
public class _396_RotateFunction {
    /**
     * 396. Rotate Function
     * Given an array of integers A and let n to be its length.

     Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

     F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

     Calculate the maximum value of F(0), F(1), ..., F(n-1).

     Note:
     n is guaranteed to be less than 105.

     Example:

     A = [4, 3, 2, 6]
          6 4 3 2
     Ak-1     2 6 4 3
     Ak       3 2 6 4

     F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
     F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
     F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
     F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

     So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

     F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
     F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1]
     = 0 * Bk[1] + 1 * Bk[2] + ... + (n-2) * Bk[n-1] + (n-1) * Bk[0]
     Then,

     F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
     = (Bk[0] + ... + Bk[n-1]) - nBk[0]
     = sum - nBk[0]
     Thus,

     F(k) = F(k-1) + sum - nBk[0]
     What is Bk[0]?

     k = 0; B[0] = A[0];
     k = 1; B[0] = A[len-1];
     k = 2; B[0] = A[len-2];

     time : O(n)
     space : O(1)

     * @param A
     * @return
     */
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int candidate = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            candidate += A[i] * i;
        }
        int res = candidate;
        for (int i = A.length - 1; i > 0; i--) {
            candidate = candidate + sum - A[i] * A.length;
            res = Math.max(res, candidate);
        }
        return res;
    }
}
