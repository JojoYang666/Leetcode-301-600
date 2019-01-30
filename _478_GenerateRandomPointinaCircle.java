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
public class _478_GenerateRandomPointinaCircle {

    /**
     * Given the radius and x-y positions of the center of a circle,
     * write a function randPoint which generates a uniform random point in the circle.

     Note:

     input and output values are in floating-point.
     radius and x-y position of the center of the circle is passed into the class constructor.
     a point on the circumference of the circle is considered to be in the circle.
     randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.

     time : O(1)
     space : O(1)
     */
    double rad, xc, yc;
    public _478_GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        rad = radius;
        xc = x_center;
        yc = y_center;
    }

    public double[] randPoint() {
        double x0 = xc - rad;
        double y0 = yc - rad;

        while (true) {
            double xg = x0 + Math.random() * rad * 2;
            double yg = y0 + Math.random() * rad * 2;
            if (Math.sqrt(Math.pow((xg - xc), 2)) + Math.sqrt(Math.pow((yg - yc), 2)) <= rad) {
                return new double[]{xg, yg};
            }
        }
    }

    public void _478_GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        rad = radius;
        xc = x_center;
        yc = y_center;
    }

    public double[] randPoint2() {
        double d = rad * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[]{d * Math.cos(theta) + xc, d * Math.sin(theta) + yc};
    }
}
