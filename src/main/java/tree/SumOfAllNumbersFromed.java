package tree;

/**
 * Given a binary tree, where every node value is a Digit from 1-9 .Find the sum of all the numbers which are formed from root to leaf paths.

 For example consider the following Binary Tree.

          6
       /      \
     3          5
   /   \          \
 2     5          4
     /   \
    7     4
 There are 4 leaves, hence 4 root to leaf paths:
 Path                    Number
 6->3->2                   632
 6->3->5->7               6357
 6->3->5->4               6354
 6->5>4                    654
 Answer = 632 + 6357 + 6354 + 654 = 13997
 */
public class SumOfAllNumbersFromed {

    public static void main(String... args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.right.right = new Node(4);
        root.left.right.left = new Node(7);
        System.out.println(treePathSum(root));
    }
    private static int treePathSum(Node node) {
        return treePathSumUtil(node, 0);
    }
    private static int treePathSumUtil(Node node, int val) {
        if (node == null) return 0;
        val = val * 10 + node.data;
        if (node.left == null && node.right == null) return val;
        return treePathSumUtil(node.left, val) + treePathSumUtil(node.right, val);
    }
    private static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
}
