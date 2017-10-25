package list;

/**
 * write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. if x is contained within the list, the values of x only need to be after
 * the elements less than x. the partition element x can appear anywhere in the "right partition"; it doesn't need to appear
 * between the left and right partitions.
 */
public class LinkedListPartition {

    public static void main(String... args) {
        Node n1 = new Node(3);
        n1.next = new Node(5);
        n1.next.next = new Node(8);
        n1.next.next.next = new Node(5);
        n1.next.next.next.next = new Node(10);
        n1.next.next.next.next.next = new Node(2);
        n1.next.next.next.next.next.next = new Node(1);

        Node result = partition(n1, 5);
        printLinkedList(result);
    }

    private static Node partition(Node node, int x) {
        Node head = node;
        Node tail = node;

        while(node != null) {
            Node next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else  {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    private static void printLinkedList(Node node) {
        if (node == null) return;
        System.out.println(node.data);
        printLinkedList(node.next);
    }

    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
