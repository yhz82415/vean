package tree;

/**
 * https://www.youtube.com/watch?v=13m9ZCB8gjw
 */
public class LowestCommonAncestor {

    public static void main(String... args) {
        Node root = new Node(3);
        root.left = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(11);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(5);
        root.right = new Node(8);
        root.right.right = new Node(13);
        root.right.right.left = new Node(7);
        System.out.println(lcs(root, 2, 5));
    }
    private static Integer lcs (Node node, int num1, int num2) {
        if (node == null) return null;
        if (node.data == num1 || node.data == num2) return node.data; // base case: found one of the number, return number

        Integer left = lcs(node.left, num1, num2);
        Integer right = lcs(node.right, num1, num2);
        if (left != null && right != null) return node.data;
        if (left == null && right == null) return null;
        return left != null ? left : right;
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
