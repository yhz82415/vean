package tree;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from root node down to the nearest leaf node.
 */
public class MinimumDepthOfTree {

    public static void main(String... args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("min depth: " + findMinDepth(root));
    }
    public static int findMinDepth(Node root) {
        if (root == null) return 0;

        return Math.min(findMinDepth(root.left), findMinDepth(root.right)) + 1;
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}


