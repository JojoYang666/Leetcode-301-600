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
public class _374_GuessNumberHigherorLower {
    /**
     * 374. Guess Number Higher or Lower
     *
     * We are playing the Guess Game. The game is as follows:

     I pick a number from 1 to n. You have to guess which number I picked.

     Every time you guess wrong, I'll tell you whether the number is higher or lower.

     You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

     -1 : My number is lower
     1 : My number is higher
     0 : Congrats! You got it!


     * time : O(logn);
     * space : O(1);
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (guess((mid)) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (guess(start) == 0) return start;
        return end;
    }


    // 防止编译器报错函数
    public int guess(int num) {
        return 0;
    }
}
