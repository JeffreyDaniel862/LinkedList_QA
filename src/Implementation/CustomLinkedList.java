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
        if (current == null) {
            this.head = newNode;
            return;
        }
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

    // QUESTIONS

    // QA - 1) Remove Duplicates from Sorted List
    // Question link : https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

    public void removeDuplicates() {
        Node current = this.head;
        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
            } else current = current.next;
        }
        this.display();
    }

    //QA - 2 Remove Duplicates from Sorted List II
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
    public void makeListDistinct() {
        Node ancestor = null;
        Node previous = this.head;
        if (previous == null || previous.next == null) return;
        Node current = previous.next;
        while (current != null) {
            if (previous.value == current.value) {
                if (previous == this.head) {
                    previous = getCurrent(current).next;
                    this.head = previous;
                } else {
                    previous = getCurrent(current).next;
                    ancestor.next = previous;
                }
                if (previous != null) current = previous.next;
                else current = null;
            } else {
                ancestor = previous;
                previous = current;
                current = current.next;
            }

        }
    }
    private Node getCurrent(Node current) {
        while (current.next != null && current.value == current.next.value) {
            current = current.next;
        }
        return current;
    }

    // QA - 3 Merge Two Sorted Lists
    // https://leetcode.com/problems/merge-two-sorted-lists/description/

    public CustomLinkedList mergeLists(CustomLinkedList list, CustomLinkedList list2) {
        Node head1 = list.head;
        Node head2 = list2.head;
        CustomLinkedList answer = new CustomLinkedList();

        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                answer.append(head1.value);
                head1 = head1.next;
            } else {
                answer.append(head2.value);
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            while (head2 != null) {
                answer.append(head2.value);
                head2 = head2.next;
            }
        } else {
            while (head1 != null) {
                answer.append(head1.value);
                head1 = head1.next;
            }
        }
        return answer;
    }
}
