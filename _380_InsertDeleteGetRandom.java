package leetcode_1To300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
public class _380_InsertDeleteGetRandom {
    /**
     * 380. Insert Delete GetRandom O(1)
     * Design a data structure that supports all following operations in average O(1) time.

     insert(val): Inserts an item val to the set if not already present.
     remove(val): Removes an item val from the set if present.
     getRandom: Returns a random element from current set of elements. Each element must have
     the same probability of being returned.

     time : O(1);
     */

    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rmd;

    public _380_InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rmd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.remove(val);
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}
