package org.example.linkedlist;


public class MergeInBetweenLinkedList {

    public static void main(String[] args) {
        ListNode listnode1 = new ListNode(10, new ListNode(1, new ListNode(13, new ListNode(6, new ListNode(9, new ListNode(5))))));
        ListNode listNode2 = new ListNode(1000, new ListNode(1001, new ListNode(1002)));
        mergeInBetween(listnode1, 3, 4, listNode2);
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0, list1);
        int diff = b - a;
        ListNode forA = list1;
        ListNode forB = list1;
        while (forB != null && forB.next != null && diff > 0) {
            forB = forB.next;
            diff--;
        }

        while (forA != null && forA.next != null && forB != null && forB.next != null && a > 0) {
            if (a > 1) {
                forA = forA.next;
            }
            forB = forB.next;
            a--;
        }
        ListNode start = list2;
        ListNode end = list2;
        while (end != null && end.next != null) {
            end = end.next;
        }
        forA.next = start;
        forB.next = end;
        return dummy.next;
    }
}
