package Implementation;

public class DoublyLinkedList {

    private Node head;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    private static class Node {
        private final int value;
        private Node previous;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private Node getTail() {
        if (this.isEmpty()) return null;
        Node last = this.head;
        while (last.next != null) last = last.next;
        return last;
    }

    private Node get(int index) {
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = this.head;
        if (!this.isEmpty()) this.head.previous = newNode;
        this.head = newNode;
        this.size++;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        Node last = this.getTail();
        if (last == null) this.head = newNode;
        else {
            newNode.previous = last;
            last.next = newNode;
        }
        this.size++;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > this.size) return;
        if (index == 0) {
            prepend(value);
            return;
        }
        if (index == this.size) {
            append(value);
            return;
        }
        Node current = this.get(index - 1);
        Node newNode = new Node(value, current, current.next);
        current.next.previous = newNode;
        current.next = newNode;
        this.size++;
    }

    public void display() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }

    public void displayReverse() {
        Node last = this.getTail();
        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.previous;
        }
        System.out.print("START");
    }
}
