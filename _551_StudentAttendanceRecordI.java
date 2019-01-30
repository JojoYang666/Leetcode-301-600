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
public class _551_StudentAttendanceRecordI {

    /**
     * You are given a string representing an attendance record for a student.
     * The record only contains the following three characters:
     'A' : Absent.
     'L' : Late.
     'P' : Present.
     A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
     or more than two continuous 'L' (late).

     You need to return whether the student could be rewarded according to his attendance record.

     Example 1:

     Input: "PPALLP"
     Output: True
     Example 2:

     Input: "PPALLL"
     Output: False

     time : O(n)
     space : O(1)
     * @param s
     * @return
     */

    public boolean checkRecord(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                count++;
            }
            if (i <= s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                return false;
            }
        }
        return count < 2;
    }
}
