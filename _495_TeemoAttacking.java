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
public class _495_TeemoAttacking {

    /**
     * In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition.
     * Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking,
     * you need to output the total time that Ashe is in poisoned condition.

     You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.

     Example 1:

     Input: [1,4], 2
     Output: 4
     Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately.
     This poisoned status will last 2 seconds until the end of time point 2.
     And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds.
     So you finally need to output 4.
     Example 2:

     Input: [1,2], 2
     Output: 3
     Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned.
     This poisoned status will last 2 seconds until the end of time point 2.
     However, at the beginning of time point 2, Teemo attacks Ashe again who is already in poisoned status.
     Since the poisoned status won't add up together, though the second poisoning attack will still work at time point 2,
     it will stop at the end of time point 3.
     So you finally need to output 3.

     time : O(n)
     space : O(1)

     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            sum += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return sum + duration;
    }
}
