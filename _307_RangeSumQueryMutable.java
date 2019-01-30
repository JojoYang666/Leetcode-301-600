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
public class _307_RangeSumQueryMutable {

    /**
     * 307. Range Sum Query - Mutable
     */
    int[] nums;
    int[] tree;
    int n;

    // time : O(n * logn)
    public _307_RangeSumQueryMutable(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    // time : O(logn)
    public void update(int i, int val) {
        if (n == 0) return;
        int diff = val - nums[i];
        nums[i] = val;
        for (int j = i + 1; j <= n; j += j & (-j)) {
            tree[j] += diff;
        }
    }

    // time : O(logn)
    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int sum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }

    /**
     * 解法2
     */
    //private int[] tree;
    //private int[] nums;

    public void NumArray(int[] nums) {
        this.nums = nums;
        int sum;
        int lowbit;
        tree = new int[nums.length + 1];
        for (int i = 1; i < tree.length; i++) {
            sum = 0;
            lowbit = i & (-i);
            for (int j = i; j > i - lowbit; j--) {
                sum = sum + nums[j - 1];
            }
            tree[i] = sum;
        }
    }

    public void update2(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        i++;
        for (; i < tree.length; i += (i & (-i))) {
            tree[i] += diff;
        }
    }

    public int sumRange2(int i, int j) {
        return sum2(j + 1) - sum2(i);
    }

    private int sum2(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }

}
