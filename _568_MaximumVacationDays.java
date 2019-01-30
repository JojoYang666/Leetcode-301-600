package leetcode_301To600;

import java.util.Arrays;

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
public class _568_MaximumVacationDays {

    /**
     * Rules and restrictions:

     You can only travel among N cities, represented by indexes from 0 to N-1. Initially, you are in the city indexed 0 on Monday.
     The cities are connected by flights. The flights are represented as a N*N matrix (not necessary symmetrical), called flights representing the airline status from the city i to the city j. If there is no flight from the city i to the city j, flights[i][j] = 0; Otherwise, flights[i][j] = 1. Also, flights[i][i] = 0 for all i.
     You totally have K weeks (each week has 7 days) to travel. You can only take flights at most once per day and can only take flights on each week's Monday morning. Since flight time is so short, we don't consider the impact of flight time.
     For each city, you can only have restricted vacation days in different weeks, given an N*K matrix called days representing this relationship. For the value of days[i][j], it represents the maximum days you could take vacation in the city i in the week j.
     You're given the flights matrix and days matrix, and you need to output the maximum vacation days you could take during K weeks.

     Example 1:

     Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]
     Output: 12
     Explanation:
     Ans = 6 + 3 + 3 = 12.

     One of the best strategies is:
     1st week : fly from city 0 to city 1 on Monday, and play 6 days and work 1 day.
     (Although you start at city 0, we could also fly to and start at other cities
     since it is Monday.)
     2nd week : fly from city 1 to city 2 on Monday, and play 3 days and work 4 days.
     3rd week : stay at city 2, and play 3 days and work 4 days.
     Example 2:

     Input:flights = [[0,0,0],[0,0,0],[0,0,0]], days = [[1,1,1],[7,7,7],[7,7,7]]
     Output: 3
     Explanation:
     Ans = 1 + 1 + 1 = 3.

     Since there is no flights enable you to move to another city, you have to stay at
     city 0 for the whole 3 weeks.
     For each week, you only have one day to play and six days to work.
     So the maximum number of vacation days is 3.
     Example 3:

     Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[7,0,0],[0,7,0],[0,0,7]]
     Output: 21
     Explanation:
     Ans = 7 + 7 + 7 = 21

     One of the best strategies is:
     1st week : stay at city 0, and play 7 days.
     2nd week : fly from city 0 to city 1 on Monday, and play 7 days.
     3rd week : fly from city 1 to city 2 on Monday, and play 7 days.

     dp[i][j]来表示 week i in city j, 最多可以得到多少个vacation

     dp[i][j] = max(dp[i - 1][k] + days[j][i]) (k = 0...N - 1, if we can go from city k to city j)

     dp[i] : 当前周城市i获得最大假期数

     time : O(K * N * N)
     space : O(n)

     * @param flights
     * @param days
     * @return
     */

    public static int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;  // city
        int K = days[0].length;  // week
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < K; i++) {
            int[] temp = new int[N];
            Arrays.fill(temp, Integer.MIN_VALUE);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (j == k || flights[k][j] == 1) {
                        temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                    }
                }
            }
            dp = temp;
        }

        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] flights = new int[][] {
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };
        int[][] days = new int[][] {
                {1, 3, 1},
                {6, 0, 3},
                {3, 3, 3}
        };
        maxVacationDays(flights, days);
    }
}
