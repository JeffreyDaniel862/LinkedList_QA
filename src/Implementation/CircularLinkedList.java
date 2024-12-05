package Implementation;

public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    private static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value, this.head);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public void remove() {

    }

    public void display() {
        Node current = this.head;
        if (this.head != null) {
            do {
                if (current != this.tail) System.out.print(current.value + " -> ");
                else System.out.print(current.value);
                current = current.next;
            } while (current != this.head && current != null);
        }
    }
}
