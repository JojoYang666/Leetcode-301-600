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
public class _302_SmallestRectangleEnclosingBlackPixels {
    /**
     * 302. Smallest Rectangle Enclosing Black Pixels
     * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
     * The black pixels are connected, i.e., there is only one black region.
     * Pixels are connected horizontally and vertically. Given the location (x, y) of
     * one of the black pixels, return the area of the smallest (axis-aligned) rectangle
     * that encloses all black pixels.

     For example, given the following image:

     [
     "0010",
     "0110",
     "0100"
     ]

     011
     011
     011

     and x = 0, y = 2,
     Return 6.

     time : O(m log n + n log m)
     space : O(1)

     * @param image
     * @param x
     * @param y
     * @return
     */
    public int minArea(char[][] image, int x, int y) {
        int row = image.length;
        int col = image[0].length;

        int left = binarySearchLeft(image, 0, y, true);
        int right = binarySearchRight(image, y, col - 1, true);

        int top = binarySearchLeft(image, 0, x, false);
        int bottom = binarySearchRight(image, x, row - 1, false);

        return (right - left + 1) * (bottom - top + 1);
    }

    private int binarySearchLeft(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (hasBlack(image, left, isHor)) {
            return left;
        }
        return right;
    }

    private int binarySearchRight(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (hasBlack(image, right, isHor)) {
            return right;
        }
        return left;
    }

    private boolean hasBlack(char[][] image, int x, boolean isHor) {
        if (isHor) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][x] == '1') return true;
            }
        } else {
            for (int i = 0; i < image[0].length; i++) {
                if (image[x][i] == '1') return true;
            }
        }
        return false;
    }
}
