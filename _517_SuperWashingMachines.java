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
public class _517_SuperWashingMachines {

    /**
     * You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.

     For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine
     to one of its adjacent washing machines at the same time .

     Given an integer array representing the number of dresses in each washing machine from left to right on the line,
     you should find the minimum number of moves to make all the washing machines have the same number of dresses.
     If it is not possible to do it, return -1.

     Example1

     Input: [1,0,5]

     Output: 3

     Explanation:
     1st move:    1     0 <-- 5    =>    1     1     4
     2nd move:    1 <-- 1 <-- 4    =>    2     1     3
     3rd move:    2     1 <-- 3    =>    2     2     2
     Example2

     Input: [0,3,0]

     Output: 2

     Explanation:
     1st move:    0 <-- 3     0    =>    1     2     0
     2nd move:    1     2 --> 0    =>    1     1     1
     Example3

     Input: [0,2,0]

     Output: -1

     Explanation:
     It's impossible to make all the three washing machines have the same number of dresses.

     time : O(n)
     space : O(1)

     * @param machines
     * @return
     */
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int machine : machines) {
            total += machine;
        }
        if (total % machines.length != 0) {
            return -1;
        }
        int avg = total / machines.length;
        int res = 0;
        int count = 0;
        for (int load : machines) {
            count += load - avg;
            res = Math.max(res, Math.max(Math.abs(count), load - avg));
        }
        return res;
    }
}
