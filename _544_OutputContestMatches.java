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
public class _544_OutputContestMatches {

    /**
     * Input: 8
     Output: (((1,8),(4,5)),((2,7),(3,6)))
     Explanation:
     First round: (1,8),(2,7),(3,6),(4,5)
     Second round: ((1,8),(4,5)),((2,7),(3,6))
     Third round: (((1,8),(4,5)),((2,7),(3,6)))
     Since the third round will generate the final winner, you need to output the answer (((1,8),(4,5)),((2,7),(3,6))).

     time : O(n)
     space : O(n)
     * @param n
     * @return
     */
    public String findContestMatch(int n) {
        String[] res = new String[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = String.valueOf(i + 1);
        }
        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                res[i] = "(" + res[i] + "," + res[n - 1 - i] + ")";
            }
            n /= 2;
        }
        return res[0];
    }
}
