package leetcode_1To300;

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
public class _309_BestTimetoBuyandSellStockwithCooldown {
    /**
     * 309. Best Time to Buy and Sell Stock with Cooldown
     * buy[i]表示在第i天之前最后一个操作是买，此时的最大收益。

     sell[i]表示在第i天之前最后一个操作是卖，此时的最大收益。

     rest[i]表示在第i天之前最后一个操作是冷冻期，此时的最大收益。

     我们写出递推式为：

     buy[i]  = max(rest[i-1] - price, buy[i-1])
     sell[i] = max(buy[i-1] + price, sell[i-1])
     rest[i] = max(sell[i-1], buy[i-1], rest[i-1])

     上述递推式很好的表示了在买之前有冷冻期，买之前要卖掉之前的股票。一个小技巧是如何保证[buy, rest, buy]的情况不会出现，
     这是由于buy[i] <= rest[i]， 即rest[i] = max(sell[i-1], rest[i-1])，这保证了[buy, rest, buy]不会出现。

     另外，由于冷冻期的存在，我们可以得出rest[i] = sell[i-1]，这样，我们可以将上面三个递推式精简到两个：

     buy[i]  = max(sell[i-2] - price, buy[i-1])
     sell[i] = max(buy[i-1] + price, sell[i-1])

     time : O(n)
     space : O(1)

     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sell = 0, prevSell = 0;
        int buy = Integer.MIN_VALUE, prevBuy = 0;
        for (int price : prices) {
            prevBuy = buy;
            buy = Math.max(prevSell - price, prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy + price, prevSell);
        }
        return sell;
    }
}
