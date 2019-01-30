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
public class _506_RelativeRanks {

    /**
     * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
     * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

     Example 1:

     Input: [5, 4, 3, 2, 1]
     Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     Explanation: The first three athletes got the top three highest scores,
     so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
     For the left two athletes, you just need to output their relative ranks according to their scores.

     time : O(n)
     space : O(n)

     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]] = i + 1;
        }
        int medal = 1;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != 0) {
                if (medal == 1) {
                    res[bucket[i] - 1] = "Gold Medal";
                } else if (medal == 2) {
                    res[bucket[i] - 1] = "Silver Medal";
                } else if (medal == 3) {
                    res[bucket[i] - 1] = "Bronze Medal";
                } else {
                    res[bucket[i] - 1] = String.valueOf(medal);
                }
                medal++;
            }
        }
        return res;
    }
}
