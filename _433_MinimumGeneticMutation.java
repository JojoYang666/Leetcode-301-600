package leetcode_301To600;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
public class _433_MinimumGeneticMutation {

    /**
     * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

     Suppose we need to investigate about a mutation (mutation from "start" to "end"),
     where ONE mutation is defined as ONE single character changed in the gene string.

     For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

     Also, there is a given gene "bank", which records all the valid gene mutations.
     A gene must be in the bank to make it a valid gene string.

     Now, given 3 things - start, end, bank, your task is to determine
     what is the minimum number of mutations needed to mutate from "start" to "end".
     If there is no such a mutation, return -1.

     Note:

     Starting point is assumed to be valid, so it might not be included in the bank.
     If multiple mutations are needed, all mutations during in the sequence must be valid.
     You may assume start and end string is not the same.


     Example 1:

     start: "AACCGGTT"
     end:   "AACCGGTA"
     bank: ["AACCGGTA"]

     return: 1


     Example 2:

     start: "AACCGGTT"
     end:   "AAACGGTA"
     bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

     return: 2


     Example 3:

     start: "AAAAACCC"
     end:   "AACCCCCC"
     bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

     return: 3

     time : O(n * max(len))
     space : O(n)

     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }

        HashSet<String> bankSet = new HashSet<>();
        for (String s: bank) {
            bankSet.add(s);
        }

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level = 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return level;
                }

                char[] curArray = cur.toCharArray();
                for (int i = 0; i < curArray.length; i++) {
                    char old = curArray[i];
                    for (char c: charSet) {
                        curArray[i] = c;
                        String next = new String(curArray);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    curArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
