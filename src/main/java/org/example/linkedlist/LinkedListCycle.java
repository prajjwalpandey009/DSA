package org.example.linkedlist;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode = new ListNode(3, listNode2.setNext(new ListNode(0, new ListNode(-4, listNode2))));
        ListNode listNode = new ListNode(1, new ListNode(2));
        System.out.println(hasCycle(listNode));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }
}
