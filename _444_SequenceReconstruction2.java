package leetcode_301To600;

import java.util.*;

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
public class _444_SequenceReconstruction2 {

    /**
     * org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
     * time : O(V + E)
     * space : O(n)
     * @param org
     * @param seqs
     * @return
     */
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int i : seq) {
                map.putIfAbsent(i, new HashSet<>());
                indegree.putIfAbsent(i, 0);
            }
        }

        for (List<Integer> seq : seqs) {
            if (seq.size() == 1) continue;
            for (int i = 1; i < seq.size(); i++) {
                if (map.get(seq.get(i - 1)).add(seq.get(i))) {
                    indegree.put(seq.get(i), indegree.get(seq.get(i) + 1));
                }
            }
        }

        if (org.length != indegree.size()) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        int res = 0;
        while (queue.size() == 1) {
            for (int next : map.get(queue.poll())) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
            res++;
        }
        return res == indegree.size();
    }

}
