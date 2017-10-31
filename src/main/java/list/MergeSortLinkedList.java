package list;

public class MergeSortLinkedList {
    public static void main(String... args) {
        Node head = new Node(15);
        head.next = new Node(10);
        head.next.next = new Node(5);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(2);
        Node sorted = mergeSort(head);
        printList(sorted);
    }

    private static Node mergeSort(Node h) {
        if (h == null || h.next == null) return h;
        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(h);
        Node right = mergeSort(nextOfMiddle);
        Node sorted = sortedMerge(left, right);
        return sorted;
    }

    private static Node sortedMerge(Node left, Node right) {
        Node result = null;
        if (left == null) return right;
        if (right == null) return left;
        if (left.data <= right.data) {
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }
        return result;
    }

    private static Node getMiddle(Node h) {
        if (h == null) return h;
        Node fast = h.next;
        Node slow = h;
        while (fast != null) {
            fast = fast.next;
            if(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    private static void printList(Node node) {
        if(node == null) return;
        System.out.print(node.data + "->");
        printList(node.next);
    }
    private static class Node {
        Node next;
        int data;
        public Node(int data) {
            this.data = data;
        }
    }
}
