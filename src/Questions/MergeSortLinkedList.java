package Questions;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeSortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
                tail = tail.next;
            } else {
                tail.next = right;
                tail = tail.next;
                right = right.next;
            }
        }
        tail.next = (left == null) ? right : left;
        return dummy.next;
    }

    // get middle node and split the node into two using the middle
    private ListNode getMid (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode end = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast != null && fast.next != null) end = end.next;
        }
        end.next = null;
        return slow;
    }
}