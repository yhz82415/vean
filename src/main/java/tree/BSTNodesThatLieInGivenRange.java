package tree;

/**
 * Given a Binary Search Tree (BST) and a range, count number of nodes that lie in the given range.

 Examples:

 Input:
       10
     /    \
    5       50
  /       /  \
 1       40   100
 Range: [5, 45]

 Output:  3
 There are three nodes in range, 5, 10 and 40
 */
public class BSTNodesThatLieInGivenRange {

    public static void main(String... args) {
        Node root = new Node(10);
        root.left     = new Node(5);
        root.right     = new Node(50);
        root.left.left = new Node(1);
        root.right.left = new Node(40);
        root.right.right = new Node(100);
        /* Let us constructed BST shown in above example
          10
        /    \
      5       50
     /       /  \
    1       40   100   */
        int l=5;
        int h=45;
        System.out.println(getCount(root, l, h));
    }
    private static int getCount(Node node, int low, int high) {
        if (node == null) return 0;
        if (node.data >= low && node.data <= high) return 1 + getCount(node.left, low, high) + getCount(node.right, low, high);
        else if (node.data < low) return getCount(node.right, low, high);
        else return getCount(node.left, low, high);
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
