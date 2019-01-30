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
public class _345_ReverseVowelsofaString {
    /**
     * 345. Reverse Vowels of a String
     * Write a function that takes a string as input and reverse only the vowels of a string.

     Example 1:
     Given s = "hello", return "holle".

     Example 2:
     Given s = "leetcode", return "leotcede".

     time : O(n);
     space : O(n);
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        char[] array = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && vowels.indexOf(array[start]) == -1) {
                start++;
            }
            while (start < end && vowels.indexOf(array[end]) == -1) {
                end--;
            }
            char temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
        return String.valueOf(array);
    }
}
