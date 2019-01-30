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
public class _533_LonelyPixelII {

    /**
     * Given a picture consisting of black and white pixels, and a positive integer N,
     * find the number of black pixels located at some specific row R and column C that align with
     * all the following rules:

     Row R and column C both contain exactly N black pixels.
     For all rows that have a black pixel at column C, they should be exactly the same as row R
     The picture is represented by a 2D char array consisting of 'B' and 'W',
     which means black and white pixels respectively.

     Example:

     Input:
     [['W', 'B', 'W', 'B', 'B', 'W'],
     ['W', 'B', 'W', 'B', 'B', 'W'],
     ['W', 'B', 'W', 'B', 'B', 'W'],
     ['W', 'W', 'B', 'W', 'B', 'W']]

     N = 3
     Output: 6
     Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
             0    1    2    3    4    5         column index
     0    [['W', 'B', 'W', 'B', 'B', 'W'],
     1     ['W', 'B', 'W', 'B', 'B', 'W'],
     2     ['W', 'B', 'W', 'B', 'B', 'W'],
     3     ['W', 'W', 'B', 'W', 'B', 'W']]
     row index

     Take 'B' at row R = 0 and column C = 1 as an example:
     Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels.
     Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2.
     They are exactly the same as row R = 0.

     time : O(m * n)
     space : O(max(m,n))

     * @param picture
     * @param N
     * @return
     */
    public int findBlackPixel(char[][] picture, int N) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] col = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            int row = 0;
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    col[j]++;
                    row++;
                }
            }
            if (row == N) {
                String s = new String(picture[i]);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int res = 0;
        for (String s : map.keySet()) {
            if (map.get(s) != N) continue;
            for (int i = 0; i < col.length; i++) {
                if (s.charAt(i) == 'B' && col[i] == N) {
                    res += N;
                }
            }
        }
        return res;
    }
}
