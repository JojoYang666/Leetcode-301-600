package leetcode_301To600;

import java.util.HashMap;
import java.util.Random;

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
public class _535_EncodeAndDecodeTinyURL {

    HashMap<String, String> map = new HashMap<>();
    String mapping = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";

    /**
     * time : O(1)
     * space : O(1) n 个 String O(n)
     * @param longUrl
     * @return
     */
    public String encode(String longUrl){
        Random random = new Random();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 6; i++) {
             int index = random.nextInt(mapping.length());
             res.append(mapping.charAt(index));
        }
        String url = "https://tinyurl.com/" + res.toString();
        if (!map.containsKey(url)) {
            map.put(url, longUrl);
        }
        return url;
    }

    public String decode(String shortUrl){
        return map.get(shortUrl);
    }
}
