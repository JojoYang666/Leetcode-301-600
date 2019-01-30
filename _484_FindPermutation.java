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
public class _484_FindPermutation {

    /**
     * Example 1:

     Input: "I"
     Output: [1,2]
     Explanation: [1,2] is the only legal initial spectial string can construct secret signature "I",
     where the number 1 and 2 construct an increasing relationship.
     Example 2:

     Input: "DI"
     Output: [2,1,3]
     Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI",
     but since we want to find the one with the smallest lexicographical permutation, you need to output [2,1,3]

     time : O(n)
     space : O(n)
     * @param s
     * @return
     */
    public int[] findPermutation(String s) {
        int len = s.length();
        int[] res = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            res[i] = i + 1;
        }
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'D') {
                int start = i;
                while (i < len && s.charAt(i) == 'D') {
                    i++;
                }
                reverse(res, start, i);
            }
        }
        return res;
    }

    public void reverse(int[] array,int left,int right){
        while(left<right){
            int t = array[left];
            array[left] = array[right];
            array[right] = t;
            left++;
            right--;
        }
    }
}
