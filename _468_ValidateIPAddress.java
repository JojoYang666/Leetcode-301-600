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
public class _468_ValidateIPAddress {

    /**
     * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

     IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, 
     each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

     Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

     IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. 
     The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
     Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones,
     so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

     However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. 
     For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

     Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

     Note: You may assume there is no extra space or special characters in the input string.

     Example 1:

     Input: "172.16.254.1"

     Output: "IPv4"

     Explanation: This is a valid IPv4 address, return "IPv4".
     Example 2:

     Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

     Output: "IPv6"

     Explanation: This is a valid IPv6 address, return "IPv6".
     Example 3:

     Input: "256.256.256.256"

     Output: "Neither"

     Explanation: This is neither a IPv4 address nor a IPv6 address.

     time : O(n)
     space : O(1)
     */

    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP.toUpperCase())) {
            return "IPv6";
        }
        return "Neither";
    }

    public boolean isIPv4(String IP) {
        int count = 0;
        for (char ch : IP.toCharArray()) {
            if (ch == '.') {
                count++;
            }
        }
        if (count != 3) {
            return false;
        }

        String[] fields = IP.split("\\.");
        if (fields.length != 4) {
            return false;
        }
        for (String field : fields) {
            if (field.isEmpty() || field.length() > 3) {
                return false;
            }
            for (int i = 0; i < field.length(); i++) {   // 视频 fields.length，IDE自动的写错了
                if (!Character.isDigit(field.charAt(i))) {
                    return false;
                }
            }
            int num = Integer.valueOf(field);
            if (!String.valueOf(num).equals(field) || num < 0 || num > 255) {  // 加个 ！，视频忘了加
                return false;
            }
        }
        return true;
    }

    public boolean isIPv6(String IP) {
        int count = 0;
        for (char ch : IP.toCharArray()) {
            if (ch == ':') {
                count++;
            }
        }
        if (count != 7) {
            return false;
        }

        String[] fields = IP.split(":");  // 视频忘改为 : 了
        if (fields.length != 8) {
            return false;
        }
        for (String field : fields) {
            if (field.isEmpty() || field.length() > 4) {
                return false;
            }
            for (int i = 0; i < field.length(); i++) {  // 视频 fields.length，IDE自动的写错了
                if (!Character.isDigit(field.charAt(i)) && (field.charAt(i) < 'A' || field.charAt(i) > 'F')) {
                    return false;
                }
            }
        }
        return true;
    }

}
