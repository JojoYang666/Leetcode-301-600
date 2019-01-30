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
public class _471_EncodeStringwithShortestLength {

    /**
     * Example 1:

     Input: "aaa"
     Output: "aaa"
     Explanation: There is no way to encode it such that it is shorter than the input string,
     so we do not encode it.


     Example 2:

     Input: "aaaaa"
     Output: "5[a]"
     Explanation: "5[a]" is shorter than "aaaaa" by 1 character.


     Example 3:

     Input: "aaaaaaaaaa"
     Output: "10[a]"
     Explanation: "a9[a]" or "9[a]a" are also valid solutions,
     both of them have the same length = 5, which is the same as "10[a]".


     Example 4:

     Input: "aabcaabcd"
     Output: "2[aabc]d"
     Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".


     Example 5:

     Input: "abbbabbbcabbbabbbc"
     Output: "2[2[abbb]c]"
     Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c",
     so one answer can be "2[2[abbb]c]".

     time : O(n ^ 4)
     space : O(n ^ 2)

     * @param s
     * @return
     */
    public static String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];
        for (int len = 0; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                int j = i + len;
                String substr = s.substring(i, j + 1);
                if (j - i < 4) {
                    dp[i][j] = substr;
                } else {
                    dp[i][j] = substr;
                    for (int k = i; k < j; k++) {
                        if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                    for (int k = 0; k < substr.length(); k++) {
                        String repeatStr = substr.substring(0, k + 1);
                        if (substr.length() % repeatStr.length() == 0
                                && substr.replaceAll(repeatStr, "").length() == 0) {
                            String temp = substr.length() / repeatStr.length() + "[" + dp[i][i + k] + "]";
                            if (temp.length() < dp[i][j].length()) {
                                dp[i][j] = temp;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
