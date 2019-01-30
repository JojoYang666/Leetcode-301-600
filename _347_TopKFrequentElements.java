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
public class _347_TopKFrequentElements {

    /**
     * Given a non-empty array of integers, return the k most frequent elements.

     For example,
     Given [1,1,1,2,2,3] and k = 2, return [1,2].

     * @param nums
     * @param k
     * @return
     */
    // PriorityQueue : time : O(nlogn) space : O(n)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {  // O(klogn)
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    // TreeMap : time : O(nlogn) space : O(n)
    public List<Integer> topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (freqMap.containsKey(freq)) {
                freqMap.get(freq).add(num);
            } else {
                freqMap.put(freq, new LinkedList<>());
                freqMap.get(freq).add(num);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {  // O(klogn)
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }

    // Bucket sort : time : O(n) space : O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(num);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        /*
        for (int i = bucket.length - 1; i >= 0; i--) {
            int j = 0;
            while (bucket[i] != null && j < bucket[i].size() && k > 0) {
                res.add(bucket[i].get(j++));
                k--;
            }
        }*/
        return res;
    }
}
