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
public class _323_NumberofConnectedComponentsinanUndirectedGraph {
    /**
     * 323. Number of Connected Components in an Undirected Graph
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
     * write a function to find the number of connected components in an undirected graph.

     Example 1:
     0          3
     |          |
     1 --- 2    4
     Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

     Example 2:
     0           4
     |           |
     1 --- 2 --- 3
     Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

     Note:
     You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
     [0, 1] is the same as [1, 0] and thus will not appear together in edges.

     图 ： 点 - 边 = 1

     n = 5 4 edges n-- = 1

     time : O(edges * nodes)
     space : O(n)

     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {

        int res = n;

        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }

        for (int[] pair : edges) {
            int x = find(roots, pair[0]);
            int y = find(roots, pair[1]);
            if (x != y) {
                roots[x] = y;
                res--;
            }
        }
        return res;
    }

    private int find(int[] roots, int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }
}
