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
public class _488_ZumaGame {
    /**
     * Think about Zuma Game. You have a row of balls on the table,
     * colored red(R), yellow(Y), blue(B), green(G), and white(W). You also have several balls in your hand.

     Each time, you may choose a ball in your hand, and insert it into the row
     (including the leftmost place and rightmost place). Then,
     if there is a group of 3 or more balls in the same color touching, remove these balls.
     Keep doing this until no more balls can be removed.

     Find the minimal balls you have to insert to remove all the balls on the table.
     If you cannot remove all the balls, output -1.

     Examples:

     Input: "WRRBBW", "RB"
     Output: -1
     Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW

     Input: "WWRRBBWW", "WRBRW"
     Output: 2
     Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty

     Input:"G", "GGGGG"
     Output: 2
     Explanation: G -> G[G] -> GG[G] -> empty

     Input: "RBYYBBRRB", "YRBGB"
     Output: 3
     Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty

     time : 不确定
     space : O(1)

     */
    final int MAX_COUNT = 6;

    public int findMinStep(String board, String hand) {
        int[] count =  new int[26];
        for (int i = 0; i < hand.length(); i++) {
            count[hand.charAt(i) - 'A']++;
        }
        int res = helper(board + "#", count);
        return res == MAX_COUNT ? -1 : res;
    }

    private int helper(String s, int[] count) {
        s = remove(s);
        if (s.equals("#")) {
            return 0;
        }
        int res = MAX_COUNT;
        for (int j = 0, i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(j)) {
                continue;
            }
            int need = 3 - (i - j);
            if (count[s.charAt(j) - 'A'] >= need) {
                count[s.charAt(j) - 'A'] -= need;
                res = Math.min(res, need + helper(s.substring(0, j) + s.substring(i), count));
                count[s.charAt(j) - 'A'] += need;
            }
            j = i;
        }
        return res;
    }

    private String remove(String board) {
        for (int i = 0, j = 0; j < board.length(); j++) {
            if (board.charAt(j) == board.charAt(i)) {
                continue;
            }
            if (j - i >= 3) {
                return remove(board.substring(0, i) + board.substring(j));
            } else {
                i = j;
            }
        }
        return board;
    }

}
