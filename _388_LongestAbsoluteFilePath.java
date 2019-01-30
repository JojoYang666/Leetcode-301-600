package leetcode_1To300;

import java.util.Stack;

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
public class _388_LongestAbsoluteFilePath {
    /**
     * 388. Longest Absolute File Path
     * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
     * dir
        subdir1
        subdir2
            file.ext
     dir\ subdir2\ file.ext
      3     7         8    =  20

     dir \tsubdir1 \tsubdir2 \t\tfile.ext


     stack : 0 4 12 21
     dir : level = 0
     \tsubdir1 \tsubdir2 : level = 1
     \t\tfile.ext ; level = 2

     time : O(n)
     space : O(n)


     * @param input
     * @return
     */
    public static int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }

}
