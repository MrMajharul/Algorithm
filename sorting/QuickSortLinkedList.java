package sorting;
class QuickSortLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to get the last node of the linked list
    public static Node getTail(Node head) {
        while (head != null && head.next != null) {
            head = head.next;
        }
        return head;
    }

    // Function to partition the linked list around the pivot
    public static Node[] partition(Node head, Node tail) {
        Node pivot = tail;
        Node prev = null, cur = head, end = tail;

        Node newHead = null, newTail = null;

        while (cur != pivot) {
            if (cur.data < pivot.data) {
                // First node smaller than pivot becomes the new head
                if (newHead == null) newHead = cur;
                prev = cur;
                cur = cur.next;
            } else {
                // Move nodes greater than pivot to the end
                if (prev != null) prev.next = cur.next;
                Node temp = cur.next;
                cur.next = null;
                end.next = cur;
                end = cur;
                cur = temp;
            }
        }

        // Update new head and tail
        if (newHead == null) newHead = pivot;
        newTail = end;

        return new Node[]{newHead, pivot, newTail};
    }

    // Recursive QuickSort function
    public static Node quickSort(Node head, Node tail) {
        if (head == null || head == tail) return head;

        // Partition the list, get pivot
        Node[] partitioned = partition(head, tail);
        Node newHead = partitioned[0];
        Node pivot = partitioned[1];
        Node newTail = partitioned[2];

        // Sort left part (before pivot)
        if (newHead != pivot) {
            Node temp = newHead;
            while (temp.next != pivot) temp = temp.next;
            temp.next = null;

            newHead = quickSort(newHead, temp);

            temp = getTail(newHead);
            temp.next = pivot;
        }

        // Sort right part (after pivot)
        pivot.next = quickSort(pivot.next, newTail);

        return newHead;
    }

    // Function to print the linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test Quick Sort on a Linked List
    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Original Linked List:");
        printList(head);

        head = quickSort(head, getTail(head));

        System.out.println("Sorted Linked List:");
        printList(head);
    }
}
