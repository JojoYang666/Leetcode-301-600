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
public class _552_StudentAttendanceRecordII {

    /**
     * Given a positive integer n, return the number of all possible attendance records with length n,
     * which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.

     A student attendance record is a string that only contains the following three characters:

     'A' : Absent.
     'L' : Late.
     'P' : Present.
     A record is regarded as rewardable if it doesn't contain more than one 'A' (absent)
     or more than two continuous 'L' (late).

     Example 1:

     Input: n = 2
     Output: 8
     Explanation:
     There are 8 records with length 2 will be regarded as rewardable:
     "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
     Only "AA" won't be regarded as rewardable owing to more than one absent times.

     time : O(n)
     space : O(n)

     */
    static final int M = 1000000007;

    public int checkRecord(int n) {
        long[] PorL = new long[n + 1];
        long[] P = new long[n + 1];
        PorL[0] = P[0] = 1;
        PorL[1] = 2;
        P[1] = 1;

        for (int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
        }
        long res = PorL[n];
        for (int i = 0; i < n; i++) {
            long insertA = (PorL[i] * PorL[n - 1 - i]) % M;
            res = (res + insertA) % M;
        }
        return (int)res;
    }
}
