package Implementation;

public class Main {
    public static void main(String[] args) {
        // Calling custom linked list without tail
//        CustomLinkedList list = new CustomLinkedList();
//        CustomLinkedList list1 = new CustomLinkedList();
//        list.prepend(4);
//        list.prepend(3);
//        list.prepend(2);
//        list.prepend(1);
//        list.append(1);
//        list.append(1);
//        list1.append(2);
//        list1.append(5);
//        list1.append(7);
//        CustomLinkedList list3 = list.mergeLists(list, list1);
//        list3.display();
//        list.insert(4,3);
//        list.insert(4, 5);
//        list.insert(5, 6);
//        list.insert(6, 7);
//        list.prepend(0);
//        System.out.println("Item removed from front -> " + list.popFirst());
//        System.out.println("Item removed from Index -> " + list.popIndex(5));
//        System.out.println("Item removed from Last -> " + list.popLast());
//        System.out.println("Item is found at Index " + list.findIndex(7));
//        list.display();
//        System.out.println();
//        //Calling Custom Linked list with tail
//        Implementation.LinkedListWithTail tail = new Implementation.LinkedListWithTail();
//        tail.append(5);
//        tail.prepend(2);
//        tail.prepend(1);
//        tail.insert(2, 3);
//        tail.insert(3,4);
//        tail.append(6);
//        tail.prepend(0);
//        System.out.println("Item removed from front -> " + tail.popFirst());
//        System.out.println("Item remove from Index -> " + tail.popIndex(4));
//        System.out.println("Item removed from Last -> " + tail.popLast());
//        tail.display();

//        // Doubly linked list
//        Implementation.DoublyLinkedList dobList = new Implementation.DoublyLinkedList();
//        dobList.prepend(5);
//        dobList.prepend(4);
//        dobList.prepend(3);
//        dobList.append(6);
//        dobList.prepend(1);
//        dobList.insert(1,2);
//        dobList.display();
//        dobList.displayReverse();

//        CircularLinkedList list = new CircularLinkedList();
//        list.insert(12);
//        list.insert(34);
//        list.insert(56);
//        list.insert(78);
//        list.insert(90);
//        list.display();
        Solution sol = new Solution();
        System.out.println(sol.isHappy(19));
    }
}

// LeetCode question (Google)
// https://leetcode.com/problems/happy-number/
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSquare(slow);
            fast = sumOfSquare(sumOfSquare(fast));
        } while (slow != fast);

        return slow == 1;
    }
    private int sumOfSquare(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans = ans + (rem * rem);
            num /= 10;
        }
        System.out.println(ans);
        return ans;
    }
}