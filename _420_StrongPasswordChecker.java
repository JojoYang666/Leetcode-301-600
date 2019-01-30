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
public class _420_StrongPasswordChecker {
    /**
     * A password is considered strong if below conditions are all met:

     It has at least 6 characters and at most 20 characters.
     It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
     It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong,
     assuming other conditions are met).
     Write a function strongPasswordChecker(s), that takes a string s as input,
     and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.

     Insertion, deletion or replace of any one character are all considered as one change.

     time : O(n)
     space : O(n)
     * @param s
     * @return
     */
    public static int strongPasswordChecker(String s) {
        int res = 0;
        int lower = 1, upper = 1, digit = 1;
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length();) {
            if (Character.isLowerCase(s.charAt(i))) lower = 0;
            if (Character.isUpperCase(s.charAt(i))) upper = 0;
            if (Character.isDigit(s.charAt(i))) digit = 0;

            int j = i;
            while (i < s.length() && s.charAt(i) == s.charAt(j)) {
                i++;
            }
            arr[j] = i - j;
        }

        int miss = (lower + upper + digit);

        if (arr.length < 6) {
            int diff = 6 - s.length();
            res += diff + Math.max(0, miss - diff);
        } else {
            int over = Math.max(s.length() - 20, 0);
            res += over;
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < arr.length && over > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != (k - 1)) {
                        continue;
                    }
                    arr[i] -= Math.min(over, k);
                    over -= k;
                }
            }

            int replacement = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 3 && over > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= over;
                    over -= need;
                }

                if (arr[i] >= 3) replacement += arr[i] / 3;
            }

            res += Math.max(miss, replacement);
        }

        return res;
    }

    public static void main(String[] args) {
        strongPasswordChecker("xxxxxxxxxxxxxxxxxxxxx3yT");
    }
}
