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
public class _553_OptimalDivision {

    /**
     * Given a list of positive integers, the adjacent integers will perform the float division.
     * For example, [2,3,4] -> 2 / 3 / 4.

     However, you can add any number of parenthesis at any position to change the priority of operations.
     You should find out how to add parenthesis to get the maximum result,
     and return the corresponding expression in string format.
     Your expression should NOT contain redundant parenthesis.

     Example:

     Input: [1000,100,10,2]
     Output: "1000/(100/10/2)"
     Explanation:
     1000/(100/10/2) = 1000/((100/10)/2) = 200
     However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
     since they don't influence the operation priority. So you should return "1000/(100/10/2)".

     Other cases:
     1000/(100/10)/2 = 50
     1000/(100/(10/2)) = 50
     1000/100/10/2 = 0.5
     1000/100/(10/2) = 2

     time : O(n)
     space : O(n)
     * @param nums
     * @return
     */
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return nums[0] + "";
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder res = new StringBuilder(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res.append("/" + nums[i]);
        }
        res.append(")");
        return res.toString();
    }
}
