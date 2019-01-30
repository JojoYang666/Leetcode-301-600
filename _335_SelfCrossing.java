package leetcode_1To300;

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
public class _335_SelfCrossing {
    /**
     * 335. Self Crossing
     * You are given an array x of n positive numbers. You start at point (0,0)
     * and moves x[0] metres to the north, then x[1] metres to the west,
     * x[2] metres to the south, x[3] metres to the east and so on.
     * In other words, after each move your direction changes counter-clockwise.

     Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.

     Example 1:
     Given x = [2, 1, 1, 2],
     ?????
     ?   ?
     ???????>
     ?

     Return true (self crossing)
     Example 2:
     Given x = [1, 2, 3, 4],
     ????????
     ?      ?
     ?
     ?
     ?????????????>

     Return false (not self crossing)
     Example 3:
     Given x = [1, 1, 1, 1],
     ?????
     ?   ?
     ?????>

     Return true (self crossing)

     time : O(n)
     space : O(1)

     * @param x
     * @return
     */

    /*               i-2
    case 1 : i-1┌─┐
                └─┼─>i
                 i-3

                    i-2
    case 2 : i-1 ┌────┐
                 └─══>┘i-3
                 i  i-4      (i overlapped i-4)

    case 3 :    i-4
               ┌──┐
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2

    */
    public boolean isSelfCrossing(int[] x) {
        for (int i = 3, l = x.length; i < l; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                return true;
            } else if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                return true;
            } else if (i >= 5 && x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2]
                    && x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3]) {
                return true;
            }
        }
        return false;
    }
}
