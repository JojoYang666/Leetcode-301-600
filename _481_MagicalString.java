package leetcode_301To600;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
public class _481_MagicalString {

    /**
     * A magical string S consists of only '1' and '2' and obeys the following rules:

     The string S is magical because concatenating the number of contiguous occurrences of
     characters '1' and '2' generates the string S itself.

     The first few elements of string S is the following: S = "1221121221221121122……"

     If we group the consecutive '1's and '2's in S, it will be:

     1 22 11 2 1 22 1 22 11 2 11 22 ......

     and the occurrences of '1's or '2's in each group are:

     1 2	2 1 1 2 1 2 2 1 2 2 ......

     You can see that the occurrence sequence above is the S itself.

     Given an integer N as input, return the number of '1's in the first N number in the magical string S.

     Note: N will not exceed 100,000.

     Example 1:

     Input: 6
     Output: 3
     Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so return 3.

     time : O(n)
     space : O(n)

     * @param n
     * @return
     */
    public int magicalString(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }

        Deque<Integer> deque = new LinkedList<>(Arrays.asList(2));
        int res = 1;
        int len = 2;
        int nextNum = 1;

        while (len < n) {
            int cur = deque.removeFirst();
            if (cur == 1) {
                res++;
            }
            len++;
            for (int i = 0; i < cur; i++) {
                deque.addLast(nextNum);
            }
            nextNum = nextNum ^ 3;
        }

        return res;
    }
}
