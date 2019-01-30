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
public class _482_LicenseKeyFormatting {

    /**
     * Example 1:

     Input: S = "5F3Z-2e-9-w", K = 4

     Output: "5F3Z-2E9W"

     Explanation: The string S has been split into two parts, each part has 4 characters.
     Note that the two extra dashes are not needed and can be removed.
     Example 2:

     Input: S = "2-5g-3-J", K = 2

     Output: "2-5G-3J"

     Explanation: The string S has been split into three parts,
     each part has 2 characters except the first part as it could be shorter as mentioned above.

     time : O(n)
     space : O(n)

     * @param S
     * @param K
     * @return
     */
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
