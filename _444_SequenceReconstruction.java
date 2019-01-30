package leetcode_301To600;

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
public class _444_SequenceReconstruction {
    /**
     * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
     * The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104.
     * Reconstruction means building a shortest common supersequence of the sequences
     * in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
     * Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

     Example 1:

     Input:
     org: [1,2,3], seqs: [[1,2],[1,3]]

     Output:
     false

     Explanation:
     [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence
     that can be reconstructed.
     Example 2:

     Input:
     org: [1,2,3], seqs: [[1,2]]

     Output:
     false

     Explanation:
     The reconstructed sequence can only be [1,2].
     Example 3:

     Input:
     org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

     Output:
     true

     Explanation:
     The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
     Example 4:

     Input:
     org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

     Output:
     true

     time : O(n)
     space : O(n)

     * @param org
     * @param seqs
     * @return
     */
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int idx[] = new int[org.length + 1];
        int res = org.length - 1;
        for (int i = 0; i < org.length; i++) {
            idx[org[i]] = i;
        }
        boolean seen[] = new boolean[org.length + 1];
        boolean isEmpty = true;
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                isEmpty = false;
                int cur = seq.get(i);
                if (cur < 1 || cur > org.length) {
                    return false;
                }
                if (i == 0) continue;
                int prev = seq.get(i - 1);
                if (idx[prev] + 1 == idx[cur]) {
                    if (!seen[prev]) {
                        seen[prev] = true;
                        res--;
                    }
                } else if (idx[prev] >= idx[cur]) {
                    return false;
                }
            }
        }
        return res == 0 && !isEmpty;
    }
}
