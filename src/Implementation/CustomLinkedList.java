package Implementation;

public class CustomLinkedList {
    private Node head;
    private int size;

    public CustomLinkedList() {
        this.size = 0;
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

    private boolean isEmpty() {
        return this.size == 0;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        Node current = this.head;
        while (current.next != null) current = current.next;
        current.next = newNode;
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
        if (index < 0 || index > this.size) {
            return;
        }
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

    public void recursiveInsert (int index, int value) {
        this.head = this.recursiveInsert(index, value, this.head);
    }

    private Node recursiveInsert (int index, int value, Node current) {
        if (index == 0) {
            Node newNode = new Node(value, current);
            this.size++;
            return newNode;
        }
        current.next = recursiveInsert(index - 1, value, current.next);
        return current;
    }

    public int popFirst() {
        if (this.isEmpty()) {
            return -1;
        }
        int removed = this.head.value;
        this.head = this.head.next;
        this.size--;
        return removed;
    }

    public int popLast() {
        if (this.size <= 1) return this.popFirst();
        Node current = this.get(this.size - 2);
        int removed = current.next.value;
        current.next = null;
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

    public int findIndex(int value) {
        Node current = this.head;
        int index = 0;
        while (current != null) {
            if (current.value == value) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public void display() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.value + " --> ");
            current = current.next;
        }
        System.out.print("END");
    }
}
