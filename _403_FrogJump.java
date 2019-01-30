package leetcode_301To600;

import java.util.HashMap;
import java.util.HashSet;

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
public class _403_FrogJump {

    /**
     * A frog is crossing a river. The river is divided into x units and at each unit
     * there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

     Given a list of stones' positions (in units) in sorted ascending order, determine
     if the frog is able to cross the river by landing on the last stone. Initially,
     the frog is on the first stone and assume the first jump must be 1 unit.

     If the frog's last jump was k units, then its next jump must be either k - 1, k,
     or k + 1 units. Note that the frog can only jump in the forward direction.

     Note:

     The number of stones is ≥ 2 and is < 1,100.
     Each stone's position will be a non-negative integer < 231.
     The first stone's position is always 0.
     Example 1:

     [0,1,3,5,6,8,12,17]

     There are a total of 8 stones.
     The first stone at the 0th unit, second stone at the 1st unit,
     third stone at the 3rd unit, and so on...
     The last stone at the 17th unit.

     Return true. The frog can jump to the last stone by jumping
     1 unit to the 2nd stone, then 2 units to the 3rd stone, then
     2 units to the 4th stone, then 3 units to the 6th stone,
     4 units to the 7th stone, and 5 units to the 8th stone.
     Example 2:

     [0,1,2,3,4,8,9,11]

     Return false. There is no way to jump to the last stone as
     the gap between the 5th and 6th stone is too large.

     time : O(n ^ 2)
     space : O(n ^ 2)

     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
