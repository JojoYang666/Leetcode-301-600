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
public class _565_ArrayNesting {
    /**
     * A zero-indexed array A of length N contains all integers from 0 to N-1.
     * Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }
     * subjected to the rule below.

     Suppose the first element in S starts with the selection of element A[i] of index = i,
     the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy,
     we stop adding right before a duplicate element occurs in S.

     Example 1:

     Input: A = [5,4,0,3,1,6,2]
     Output: 4
     Explanation:
     A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

     One of the longest S[K]:
     S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = i;
            int count = 0;
            while (nums[next] != -1) {
                count++;
                int temp = next;
                next = nums[next];
                nums[temp] = -1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
