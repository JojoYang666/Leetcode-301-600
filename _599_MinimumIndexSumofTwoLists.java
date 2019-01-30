package leetcode_301To600;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
public class _599_MinimumIndexSumofTwoLists {

    /**
     * Suppose Andy and Doris want to choose a restaurant for dinner,
     * and they both have a list of favorite restaurants represented by strings.

     You need to help them find out their common interest with the least list index sum.
     If there is a choice tie between answers, output all of them with no order requirement.
     You could assume there always exists an answer.

     Example 1:

     Input:
     ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
     Output: ["Shogun"]
     Explanation: The only restaurant they both like is "Shogun".
     Example 2:

     Input:
     ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     ["KFC", "Shogun", "Burger King"]
     Output: ["Shogun"]
     Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

     time : O(m + n)
     space : O(m)
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= min) {
                if (i + j < min) {
                    res.clear();
                    min = i + j;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
