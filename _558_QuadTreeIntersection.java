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
public class _558_QuadTreeIntersection {

    /**
     * A quadtree is a tree data in which each internal node has exactly four children: topLeft, topRight,
     * bottomLeft and bottomRight. Quad trees are often used to partition a two-dimensional space
     * by recursively subdividing it into four quadrants or regions.

     We want to store True/False information in our quad tree. The quad tree is used to represent
     a N * N boolean grid. For each node, it will be subdivided into four children nodes until the values
     in the region it represents are all the same. Each node has another two boolean attributes :
     isLeaf and val.

     isLeaf is true if and only if the node is a leaf node.
     The val attribute for a leaf node contains the value of the region it represents.

     For example, below are two quad trees A and B:

     A:
     +-------+-------+   T: true
     |       |       |   F: false
     |   T   |   T   |
     |       |       |
     +-------+-------+
     |       |       |
     |   F   |   F   |
     |       |       |
     +-------+-------+
     topLeft: T
     topRight: T
     bottomLeft: F
     bottomRight: F

     B:
     +-------+---+---+
     |       | F | F |
     |   T   +---+---+
     |       | T | T |
     +-------+---+---+
     |       |       |
     |   T   |   F   |
     |       |       |
     +-------+-------+
     topLeft: T
     topRight:
        topLeft: F
        topRight: F
        bottomLeft: T
        bottomRight: T
     bottomLeft: T
     bottomRight: F


     Your task is to implement a function that will take two quadtrees and return a quadtree that represents the
     logical OR (or union) of the two trees.

     A:                 B:                 C (A or B):
     +-------+-------+  +-------+---+---+  +-------+-------+
     |       |       |  |       | F | F |  |       |       |
     |   T   |   T   |  |   T   +---+---+  |   T   |   T   |
     |       |       |  |       | T | T |  |       |       |
     +-------+-------+  +-------+---+---+  +-------+-------+
     |       |       |  |       |       |  |       |       |
     |   F   |   F   |  |   T   |   F   |  |   T   |   F   |
     |       |       |  |       |       |  |       |       |
     +-------+-------+  +-------+-------+  +-------+-------+


     time : O(n)
     space : O(h)

     * @param quadTree1
     * @param quadTree2
     * @return
     */
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }
        if (quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        }

        quadTree1.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        quadTree1.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        quadTree1.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        quadTree1.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        if (quadTree1.topLeft.isLeaf && quadTree1.topRight.isLeaf
                && quadTree1.bottomLeft.isLeaf && quadTree1.bottomRight.isLeaf
                && quadTree1.topLeft.val == quadTree1.topRight.val
                && quadTree1.topRight.val == quadTree1.bottomLeft.val
                && quadTree1.bottomLeft.val == quadTree1.bottomRight.val) {
            quadTree1.isLeaf = true;
            quadTree1.val = quadTree1.topLeft.val;
        }
        return quadTree1;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };
}
