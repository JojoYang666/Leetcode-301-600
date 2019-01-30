package leetcode_1To300;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
public class _379_DesignPhoneDirectory {
    /**
     * 379. Design Phone Directory
     * Design a Phone Directory which supports the following operations:

     get: Provide a number which is not assigned to anyone.
     check: Check if a number is available or not.
     release: Recycle or release a number.
     Example:

     // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
     PhoneDirectory directory = new PhoneDirectory(3);

     // It can return any available phone number. Here we assume it returns 0.
     directory.get();

     // Assume it returns 1.
     directory.get();

     // The number 2 is available, so return true.
     directory.check(2);

     // It returns 2, the only number that is left.
     directory.get();

     // The number 2 is no longer available, so return false.
     directory.check(2);

     // Release number 2 back to the pool.
     directory.release(2);

     // Number 2 is available again, return true.
     directory.check(2);

     * @param maxNumbers
     */

    HashSet<Integer> used = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    int maxNumbers;

    public _379_DesignPhoneDirectory(int maxNumbers) {
       this.maxNumbers = maxNumbers;
       for (int i = 0; i < maxNumbers; i++) {
           queue.offer(i);
       }
    }

    public int get() {
        Integer res = queue.poll();
        if (res == null) {
            return -1;
        }
        used.add(res);
        return res;
    }

    public boolean check(int number) {
        if (number >= maxNumbers || number < 0) {
            return false;
        }
        return !used.contains(number);
    }

    public void release(int number) {
        if (used.remove(number)) {
            queue.offer(number);
        }
    }
}
