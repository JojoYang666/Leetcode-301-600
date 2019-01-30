package leetcode_301To600;

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
public class _575_DistributeCandies {

    /**
     * Given an integer array with even length, where different numbers in this array represent
     * different kinds of candies. Each number means one candy of the corresponding kind.
     * You need to distribute these candies equally in number to brother and sister.
     * Return the maximum number of kinds of candies the sister could gain.
     Example 1:

     Input: candies = [1,1,2,2,3,3]
     Output: 3
     Explanation:
     There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
     Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
     The sister has three different kinds of candies.
     Example 2:

     Input: candies = [1,1,2,3]
     Output: 2
     Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
     The sister has two different kinds of candies, the brother has only one kind of candies.

     time : O(n)
     space : O(n)
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}
