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
public class _466_CountTheRepetitions {

    /**
     * Define S = [s,n] as the string S which consists of n connected strings s.
     * For example, ["abc", 3] ="abcabcabc".

     On the other hand, we define that string s1 can be obtained from string s2
     if we can remove some characters from s2 such that it becomes s1. For example,
     “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.

     You are given two non-empty strings s1 and s2 (each at most 100 characters long) and
     two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2,
     where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.

     Example:

     Input:
     s1="acb", n1=4
     s2="ab", n2=2

     Return:
     2

     time : O(s1 * n1 + s2 * n1)
     space : O(1)

     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count1 = 0, count2 = 0, i = 0, j = 0;

        while (count1 < n1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                if (j == s2.length()) {
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (i == s1.length()) {
                i = 0;
                count1++;
            }
        }

        return count2 / n2;
    }

    /**
     * time : O(s1 * n1)
     * space : O(n1)
     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
        int[] repeatCnt = new int[n1 + 1];
        int[] nextIdx = new int[n1 + 1];
        int j = 0, count = 0;
        for (int k = 1; k <= n1; k++) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                    if (j == s2.length()) {
                        j = 0;
                        count++;
                    }
                }
            }
            repeatCnt[k] = count;
            nextIdx[k] = j;
            for (int start = 0; start < k; start++ ) {
                if (nextIdx[start] == j) {
                    int prefixCount = repeatCnt[start];
                    int patternCount = (n1 - start) / (k - start) * (repeatCnt[k] - prefixCount);
                    int suffixCount = repeatCnt[start + (n1 - start) % (k - start)] - prefixCount;
                    return (prefixCount + patternCount + suffixCount) / n2;
                }
            }
        }
        return repeatCnt[n1] / n2;
    }
}
