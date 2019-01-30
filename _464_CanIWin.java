package leetcode_301To600;

import java.util.Arrays;
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
public class _464_CanIWin {

    /**
     * Input:
     maxChoosableInteger = 10
     desiredTotal = 11

     Output:
     false

     Explanation:
     No matter which integer the first player choose, the first player will lose.
     The first player can choose an integer from 1 up to 10.
     If the first player choose 1, the second player can only choose integers from 2 up to 10.
     The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
     Same with other integers chosen by the first player, the second player will always win.

     time : O(2^n)
     space : O(n)

     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        char[] remain = new char[maxChoosableInteger + 1];
        Arrays.fill(remain, '1');
        return canWin(remain, new HashMap<>(), desiredTotal);
    }

    private boolean canWin(char[] remain, HashMap<String, Boolean> map, int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }
        String status = new String(remain);
        if (map.containsKey(status)) {
            return map.get(status);
        }
        boolean res = false;

        for (int i = 1; i < remain.length; i++) {
            if (remain[i] == '0') {
                continue;
            }
            remain[i] = '0';
            if (!canWin(remain, map, desiredTotal - i)) {
                res = true;
            }
            remain[i] = '1';
            if (res) {
                break;
            }
        }
        map.put(status, res);
        return res;
    }
}
