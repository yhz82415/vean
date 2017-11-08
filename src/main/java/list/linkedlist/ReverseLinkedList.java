package list.linkedlist;

public class ReverseLinkedList {
    public static void main(String... args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head = reverse(head, head, null);
        print(head);
    }

    private static void print(Node node) {
        if (node == null) return;
        System.out.println(node.data);
        print(node.next);
    }

    private static Node reverse(Node head, Node curr, Node prev) {
        if (curr.next == null) {
            head = curr;
            curr.next = prev;
            return head;
        }
        Node next = curr.next;
        curr.next = prev;
        return reverse(head, next, curr);
    }

    private static class Node {
        Node next;
        int data;
        public Node(int data) {
            this.data = data;
        }
    }
}
