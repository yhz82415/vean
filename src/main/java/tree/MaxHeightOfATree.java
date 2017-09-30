package tree;

/**
 * Given a binary tree, find height of it.
 */
public class MaxHeightOfATree {

    public static void main(String... args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        System.out.println(height(root));
    }

    private static int height(Node node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight > rightHeight) return leftHeight + 1;
        else return rightHeight + 1;
    }
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
