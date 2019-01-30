package leetcode_301To600;

import java.util.ArrayList;
import java.util.HashMap;
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
public class _582_KillProcess {
    /**
     * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

     Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

     We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

     Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.

     Example 1:

     Input:
     pid =  [1, 3, 10, 5]
     ppid = [3, 0, 5, 3]
     kill = 5
     Output: [5,10]
     Explanation:
        3
      /   \
     1     5
          /
        10
     Kill 5 will also kill 10.

     time : O(m + n)
     space : O(n)

     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List<Integer> list = map.getOrDefault(ppid.get(i), new ArrayList<>());
                list.add(pid.get(i));
                map.put(ppid.get(i), list);
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(kill);
        getAllProcess(map, res, kill);
        return res;
    }

    private void getAllProcess(HashMap<Integer, List<Integer>> map, List<Integer> res, int kill) {
        if (map.containsKey(kill)) {
            for (int id : map.get(kill)) {
                res.add(id);
                getAllProcess(map, res, id);
            }
        }
    }


}
