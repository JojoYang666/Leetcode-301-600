package leetcode_1To300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
public class _310_MinimumHeightTrees {
    /**
     * 310. Minimum Height Trees
     * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
     return [3, 4]

     0 : 3
     1 : 3
     2 : 3
     3 :    4
     4 : 3
     5 : 4

     1 -- 2 -- 3

     time : O(n)
     space : O(n)

     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<HashSet<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                res.add(i);
            }
        }
        while (n > 2) {
            n -= res.size();
            List<Integer> leaves = new ArrayList<>();
            for (int i : res) {
                for (int j : adj.get(i)) {
                    adj.get(j).remove(i);
                    if (adj.get(j).size() == 1) {
                        leaves.add(j);
                    }
                }
            }
            res = leaves;
        }
        return res;
    }
}
