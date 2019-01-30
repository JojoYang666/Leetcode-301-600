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
public class _600_NonnegativeIntegerswithoutConsecutiveOnes {

    /**
     * Given a positive integer n, find the number of non-negative integers less than or equal to n,
     * whose binary representations do NOT contain consecutive ones.

     Example 1:

     Input: 5
     Output: 5
     Explanation:
     Here are the non-negative integers <= 5 with their corresponding binary representations:
     0 : 0
     1 : 1
     2 : 10
     3 : 11
     4 : 100
     5 : 101
     Among them, only integer 3 disobeys the rule (two consecutive ones)
     and the other 5 satisfy the rule.

     time : O(1)
     space : O(1)

     * @param num
     * @return
     */
    public static int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();

        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        int res = a[n - 1] + b[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') {
                break;
            }
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') {
                res -= b[i];
            }
        }

        return res;
    }

    public static int findIntegers2(int num) {
        int[] fn = new int[32];
        fn[0] = 1;
        fn[1] = 2;
        for (int i = 2; i < fn.length; i++) {
            fn[i] = fn[i - 1] + fn[i - 2];
        }

        char[] binChr = Integer.toBinaryString(num).toCharArray();
        int len = binChr.length - 1;
        int res = 0;
        boolean preBit = false;
        for (int i = 0; i < binChr.length; i++) {
            if (binChr[i] == '1') {
                res += fn[len - i];
                if (preBit) {
                    return res;
                }
                preBit = true;
            } else {
                preBit = false;
            }
        }

        return res + 1;
    }

    public static void main(String[] args) {
        findIntegers2(5);
    }

}
