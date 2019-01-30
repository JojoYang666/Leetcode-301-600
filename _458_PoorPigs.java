package leetcode_301To600;

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
public class _458_PoorPigs {
    /**
     * There are 1000 buckets, one and only one of them contains poison,
     * the rest are filled with water. They all look the same.
     * If a pig drinks that poison it will die within 15 minutes.
     * What is the minimum amount of pigs you need to figure out which bucket
     * contains the poison within one hour.

     1   2   3   4   5

     6   7   8   9  10

     11 12  13  14  15

     16 17  18  19  20

     21 22  23  24  25

     Answer this question, and write an algorithm for the follow-up general case.

     Leetcode 326, 342

     time : O(低) O(1)
     space : O(1)
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int num = minutesToTest / minutesToDie + 1;
        return (int)Math.ceil(Math.log(buckets) / Math.log(num));
    }

    public int poorPigs2(int buckets, int minutesToDie, int minutesToTest) {
        int res = 0;
        while (Math.pow(minutesToTest / minutesToDie + 1, res) < buckets) {
            res += 1;
        }
        return res;
    }
}
