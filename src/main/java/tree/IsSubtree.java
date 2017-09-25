package tree;

/**
 * Check if a binary tree is subtree of another binary tree
 * Given two binary trees, check if the first tree is subtree of the second one. A subtree of a tree T
 * is a tree S consisting of a node in T and all of its descendants in T.
 * The subtree corresponding to the root node is the entire tree; the subtree corresponding to any other node
 * is called a proper sub

 For example, in the following case, tree S is a subtree of tree T.
 Tree 2
        10
      /    \
     4       6
       \
       30


 Tree 1
         26
       /   \
     10     3
    /    \     \
 4       6      3
  \
  30

 */
public class IsSubtree {

    public static void main(String... args) {
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        Node root1 = new Node(26);
        root1.right = new Node(3);
        root1.right.right = new Node(3);
        root1.left = new Node(10);
        root1.left.left = new Node(4);
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        Node root2 = new Node(10);
        root2.right = new Node(6);
        root2.left = new Node(4);
        root2.left.right = new Node(30);

        System.out.println(isSubtree(root1, root2));
    }

    /**
     * check if root2 is a subtree of root1
     * @param root1
     * @param root2
     */
    private static boolean isSubtree(Node root1, Node root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        return identicalTree(root1, root2) || isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    private static boolean identicalTree (Node root1, Node root2) {
        /*base cases*/
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.data == root2.data &&
                identicalTree(root1.left, root2.left) &&
                identicalTree(root1.right, root2.right);
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
