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
public class _546_RemoveBoxes {

    /**
     * Given several boxes with different colors represented by different positive numbers.
     You may experience several rounds to remove boxes until there is no box left.
     Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1),
     remove them and get k*k points.
     Find the maximum points you can get.

     Example 1:
     Input:

     [1, 3, 2, 2, 2, 3, 4, 3, 1]
     Output:
     23
     Explanation:
     [1, 3, 2, 2, 2, 3, 4, 3, 1]
     ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
     ----> [1, 3, 3, 3, 1] (1*1=1 points)
     ----> [1, 1] (3*3=9 points)
     ----> [] (2*2=4 points)

     Note: The number of boxes n would not exceed 100.

     time : O(n^4)
     space : O(n^3)

     * @param boxes
     * @return
     */
    public static int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxesSub(boxes, 0, n - 1, 0, dp);
    }

    private static int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];

        for (; i + 1 <= j && boxes[i + 1] == boxes[i]; i++, k++);
        int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, dp);

        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                res = Math.max(res,
                        removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
            }
        }

        dp[i][j][k] = res;
        return res;
    }

    public static void main(String[] args) {
        removeBoxes(new int[]{1, 3, 3, 3, 1});
    }
}
