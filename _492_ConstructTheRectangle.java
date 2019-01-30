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
public class _492_ConstructTheRectangle {
    /**
     * For a web developer, it is very important to know how to design a web page's size.
     * So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page,
     * whose length L and width W satisfy the following requirements:

     1. The area of the rectangular web page you designed must equal to the given target area.

     2. The width W should not be larger than the length L, which means L >= W.

     3. The difference between length L and width W should be as small as possible.
     You need to output the length L and the width W of the web page you designed in sequence.
     Example:
     Input: 4
     Output: [2, 2]
     Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
     But according to requirement 2, [1,4] is illegal; according to requirement 3,
     [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.

     time : O(sqrt(n))
     space : O(1)

     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};
    }
}
