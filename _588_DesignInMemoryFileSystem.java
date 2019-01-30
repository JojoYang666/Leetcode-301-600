package leetcode_301To600;

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
public class _588_DesignInMemoryFileSystem {

    Node root;

    /**
     * time : O(n)
     * space : O(n) 级别
     */
    public _588_DesignInMemoryFileSystem() {
        root = new Node("/");
    }

    public List<String> ls(String path) {
        Node node = traverse(path);
        List<String> res = new ArrayList<>();
        if (node.isFile) {
            res.add(node.name);
        } else {
            for (String child : node.children.keySet()) {
                res.add(child);
            }
        }
        Collections.sort(res); // 删除 nlogn
        return res;
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {
        Node node = traverse(filePath);
        node.isFile = true;
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        Node node = traverse(filePath);
        return node.content.toString();
    }

    private Node traverse(String filePath) {
        String[] path = filePath.split("/");
        Node cur = root;
        for (int i = 1; i < path.length; i++) {
            if (!cur.children.containsKey(path[i])) {
                Node node = new Node(path[i]);
                cur.children.put(path[i], node);
            }
            cur = cur.children.get(path[i]);
        }
        return cur;
    }

    class Node {
        String name;
        boolean isFile;
        StringBuilder content;
        HashMap<String, Node> children;  // TreeMap

        public Node(String name) {
            this.name = name;
            isFile = false;
            content = new StringBuilder();
            children = new HashMap<>();
        }
    }
}
