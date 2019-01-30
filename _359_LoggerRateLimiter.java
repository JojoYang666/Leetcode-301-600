package leetcode_1To300;

import java.util.HashMap;

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
public class _359_LoggerRateLimiter {
    /**
     * 359. Logger Rate Limiter
     * Example:

     Logger logger = new Logger();

     // logging string "foo" at timestamp 1
     logger.shouldPrintMessage(1, "foo"); returns true;

     // logging string "bar" at timestamp 2
     logger.shouldPrintMessage(2,"bar"); returns true;

     // logging string "foo" at timestamp 3
     logger.shouldPrintMessage(3,"foo"); returns false;

     // logging string "bar" at timestamp 8
     logger.shouldPrintMessage(8,"bar"); returns false;

     // logging string "foo" at timestamp 10
     logger.shouldPrintMessage(10,"foo"); returns false;

     // logging string "foo" at timestamp 11
     logger.shouldPrintMessage(11,"foo"); returns true;

     time : O(1)
     space : O(n)

     */
    /** Initialize your data structure here. */
    HashMap<String, Integer> map;

    public _359_LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message,timestamp);
            return true;
        }
        return false;
    }
}
