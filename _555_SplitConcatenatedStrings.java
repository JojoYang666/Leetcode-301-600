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
public class _555_SplitConcatenatedStrings {

    /**
     * Given a list of strings, you could concatenate these strings together into a loop,
     * where for each string you could choose to reverse it or not. Among all the possible loops,
     * you need to find the lexicographically biggest string after cutting the loop,
     * which will make the looped string into a regular one.

     Specifically, to find the lexicographically biggest string, you need to experience two phases:

     Concatenate all the strings into a loop, where you can reverse some strings or not and connect
     them in the same order as given.
     Cut and make one breakpoint in any place of the loop, which will make the looped string
     into a regular one starting from the character at the cutpoint.
     And your job is to find the lexicographically biggest one among all the possible regular strings.

     Example:

     Input: "abc", "xyz"
     Output: "zyxcba"
     Explanation: You can get the looped string "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-",
     where '-' represents the looped status.
     The answer string came from the fourth looped one,
     where you could cut from the middle character 'a' and get "zyxcba".

     time : O(n * len * n)
     space : O(1)

     * @param strs
     * @return
     */
    public static String splitLoopedString(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(rev) < 0) {
                strs[i] = rev;
            }
        }
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            for (String st: new String[] {strs[i], rev}) {
                for (int k = 0; k < st.length(); k++) {
                    StringBuilder temp = new StringBuilder(st.substring(k));
                    for (int j = i + 1; j < strs.length; j++) {
                        temp.append(strs[j]);
                    }
                    for (int j = 0; j < i; j++) {
                        temp.append(strs[j]);
                    }
                    temp.append(st.substring(0, k));
                    if (temp.toString().compareTo(res) > 0) {
                        res = temp.toString();
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        splitLoopedString(new String[]{"abc", "xyz"});
    }
}
