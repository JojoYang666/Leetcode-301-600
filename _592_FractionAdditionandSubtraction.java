package leetcode_301To600;

import java.util.Scanner;

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
public class _592_FractionAdditionandSubtraction {

    /**
     * Given a string representing an expression of fraction addition and subtraction,
     * you need to return the calculation result in string format.
     * The final result should be irreducible fraction. If your final result is an integer,
     * say 2, you need to change it to the format of fraction that has denominator 1.
     * So in this case, 2 should be converted to 2/1.

     Example 1:

     Input:"-1/2+1/2"
     Output: "0/1"
     Example 2:

     Input:"-1/2+1/2+1/3"
     Output: "1/3"
     Example 3:

     Input:"1/3-1/2"
     Output: "-1/6"
     Example 4:

     Input:"5/3+1/3"
     Output: "2/1"
     Note:

     The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
     Each fraction (input and output) has format ±numerator/denominator. If the first input fraction
     or the output is positive, then '+' will be omitted.
     The input only contains valid irreducible fractions, where the numerator and
     denominator of each fraction will always be in the range [1,10]. If the denominator is 1,
     it means this fraction is actually an integer in a fraction format defined above.
     The number of given fractions will be in the range [1,10].
     The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.

     time : O(n)
     space : O(1)
     GCD: 365

     * @param expression
     * @return
     */
    public static String fractionAddition(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        int A = 0, B = 1;
        while (sc.hasNext()) {
            int a = sc.nextInt(), b = sc.nextInt();
            A = A * b + a * B;
            B *= b;
            int g = gcd(A, B);
            A /= g;
            B /= g;
        }
        return A + "/" + B;
    }

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        String s = "1/3-1/2";
        fractionAddition(s);
    }

}
