package leetcode_1To300;

import java.util.*;

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
public class _355_DesignTwitter {

    /**
     * 355. Design Twitter
     */
    private int timeStamp = 0;
    private HashMap<Integer, User> userMap;

    class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    class User {
        public int id;
        public HashSet<Integer> followed;
        public Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unFollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    /** Initialize your data structure here. */
    public _355_DesignTwitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     * */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if (!userMap.containsKey(userId)) return res;

        HashSet<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        for (int user : users) {
            Tweet tweet = userMap.get(user).tweetHead;
            if (tweet != null) {
                pq.offer(tweet);
            }
        }
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            count++;
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unFollow(followeeId);
    }
}
