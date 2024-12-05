package Implementation;

public class LinkedListWithTail {
    private Node head;
    private Node tail;
    private int size;

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

    private boolean isEmpty() {
        return this.size == 0;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
        if (this.isEmpty()) this.tail = newNode;
        this.size++;
    }

    public void append (int value) {
        if (this.isEmpty()) {
            this.prepend(value);
            return;
        }
        Node newNode = new Node(value);
        this.tail.next = newNode;
        this.tail = newNode;
        this.size++;
    }

    private Node get(int index) {
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            prepend(value);
            return;
        }
        if (index == this.size) {
            append(value);
            return;
        }
        Node current = this.get(index - 1);
        current.next = new Node(value, current.next);
        this.size++;
    }

    public int popFirst() {
        int removed = this.head.value;
        this.head = this.head.next;
        this.size--;
        if (this.isEmpty()) this.tail = null;
        return removed;
    }

    public int popLast() {
        int removed = this.tail.value;
        Node current = this.get(this.size - 2);
        current.next = null;
        this.tail = current;
        this.size--;
        return removed;
    }

    public int popIndex(int index) {
        if (index < 0 || index > this.size) {
            return -1;
        }
        if (index == 0) return popFirst();
        if (index == this.size - 1) return popLast();
        Node current = this.get(index - 1);
        int removed = current.next.value;
        current.next = current.next.next;
        this.size--;
        return removed;
    }

    public void display() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.value + " --> ");
            current = current.next;
        }
        System.out.println("END");
    }


}
