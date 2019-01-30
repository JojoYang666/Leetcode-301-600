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
public class _556_NextGreaterElementIII {

    /**
     * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer
     * which has exactly the same digits existing in the integer n and is greater in value than n.
     * If no such positive 32-bit integer exists, you need to return -1.

     Example 1:

     Input: 12
     Output: 21


     Example 2:

     Input: 21
     Output: -1

     time : O(1)
     space : O(1)

     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {
        char[] res = ("" + n).toCharArray();
        int i = res.length - 2;
        while (i >= 0 && res[i + 1] <= res[i]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = res.length - 1;
        while (j >= 0 && res[j] <= res[i]) {
            j--;
        }
        swap(res, i, j);
        reverse(res, i + 1);
        long val = Long.parseLong(new String(res));
        return val <= Integer.MAX_VALUE ? (int)val : -1;
    }

    private void reverse(char[] chars, int start) {
        int i = start, j = chars.length - 1;
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
