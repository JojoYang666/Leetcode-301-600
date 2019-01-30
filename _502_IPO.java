package leetcode_301To600;

import java.util.PriorityQueue;

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
public class _502_IPO {

    /**
     * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital,
     * LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited
     * resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way
     * to maximize its total capital after finishing at most k distinct projects.

     You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of
     Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project,
     you will obtain its pure profit and the profit will be added to your total capital.

     To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital,
     and output your final maximized capital.

     Example 1:

     Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].

     Output: 4

     Explanation: Since your initial capital is 0, you can only start the project indexed 0.
     After finishing it you will obtain profit 1 and your capital becomes 1.
     With capital 1, you can either start the project indexed 1 or the project indexed 2.
     Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
     Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.


     time : O(nlogn)
     space : O(n)
     * @param k
     * @param W
     * @param Profits
     * @param Capital
     * @return
     */
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> cap = new PriorityQueue<>((a, b) -> (a[0]- b[0]));
        PriorityQueue<int[]> pro = new PriorityQueue<>((a, b) -> (b[1]- a[1]));

        for (int i = 0; i < Profits.length; i++) {
            cap.add(new int[]{Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!cap.isEmpty() && cap.peek()[0] <= W) {
                pro.add(cap.poll());
            }
            if (pro.isEmpty()) {
                break;
            }
            W += pro.poll()[1];
        }
        return W;
    }
}
