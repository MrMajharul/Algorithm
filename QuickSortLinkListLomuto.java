class QuickSortLinkedListLomuto {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node getTail(Node head) {
        while (head != null && head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static Node partition(Node head, Node tail) {
        int pivot = tail.data;
        Node i = head, j = head;

        while (j != tail) {
            if (j.data < pivot) {
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
                i = i.next;
            }
            j = j.next;
        }

        int temp = i.data;
        i.data = tail.data;
        tail.data = temp;

        return i;
    }

    public static void quickSort(Node head, Node tail) {
        if (head == null || tail == null || head == tail) return;

        Node pivot = partition(head, tail);

        if (pivot != head) {
            Node temp = head;
            while (temp.next != pivot) temp = temp.next;
            quickSort(head, temp);
        }

        if (pivot != tail) {
            quickSort(pivot.next, tail);
        }
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Original Linked List:");
        printList(head);

        quickSort(head, getTail(head));

        System.out.println("Sorted Linked List:");
        printList(head);
    }
}
