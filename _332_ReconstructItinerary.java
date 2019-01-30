package leetcode_1To300;

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
public class _332_ReconstructItinerary {

    /**
     * 332. Reconstruct Itinerary
     * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
     * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
     * Thus, the itinerary must begin with JFK.

     Note:
     If there are multiple valid itineraries, you should return the itinerary that
     has the smallest lexical order when read as a single string. For example,
     the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
     All airports are represented by three capital letters (IATA code).
     You may assume all tickets form at least one valid itinerary.

     Example 1:
     tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

     Example 2:
     tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     Return ["JFK","ATL","JFK","SFO","ATL","SFO"].

     Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
     But it is larger in lexical order.


     DFS(HashMap) + PriorityQueue

     JFK   SFO
            |
         ATL


     time : O(nlogn)
     space : O(n)

     */

    HashMap<String, PriorityQueue<String>> map;
    List<String> res;

    public List<String> findItinerary(String[][] tickets) {
        map = new HashMap<>();
        res = new LinkedList<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        helper("JFK");
        return res;
    }

    private void helper(String airport) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            helper(map.get(airport).poll());
        }
        res.add(0, airport);
    }

    public List<String> findItinerary2(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        }

        List<String> res = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            res.add(0, stack.pop());
        }

        return res;
    }
}
