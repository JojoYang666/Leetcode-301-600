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
public class _526_BeautifulArrangement {

    /**
     * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array
     * that is constructed by these N numbers successfully if one of the following is true for
     * the ith position (1 <= i <= N) in this array:

     The number at the ith position is divisible by i.
     i is divisible by the number at the ith position.
     Now given N, how many beautiful arrangements can you construct?

     Example 1:

     Input: 2
     Output: 2
     Explanation:

     The first beautiful arrangement is [1, 2]:

     Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

     Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

     The second beautiful arrangement is [2, 1]:

     Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

     Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

     time : O(n!)
     space : O(n)
     * @param N
     * @return
     */

    int res;

    public int countArrangement(int N) {
        res = 0;
        helper(new boolean[N + 1], N, 1);
        return res;
    }

    public void helper(boolean[] visited, int N, int pos) {
        if (pos > N) {
            res++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                helper(visited, N, pos + 1);
                visited[i] = false;
            }
        }
    }
}
