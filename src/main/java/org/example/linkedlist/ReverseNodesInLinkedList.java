package org.example.linkedlist;

public class ReverseNodesInLinkedList {
    public static void main(String[] args) {
      ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
     //   ListNode listNode = new ListNode(3, new ListNode(5));
        reverseBetween(listNode, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode prevP1 = null;
        ListNode p2 = head;
        ListNode prevP2 = null;
        int count1 = 1;
        int count2 = 1;

        while (p1.next != null) {
            //Find first element and its previous node

            if (count1 < left) {
                prevP1 = p1;
                p1 = p1.next;
                count1++;
            }

            //Find Second element and its previous node
            if (count2 < right) {
                prevP2 = p2;
                p2 = p2.next;
                count2++;
            }

            if (count1 == left && count2 == right) {
                break;
            }
        }

        //swapping P1 pointer with p2
        ListNode tempNode = p2.next;

        //prev1 is in starting point
            prevP1.next = p2;
            p2.next = p1.next;

            //swapping p2 with p1
            prevP2.next = p1;
            p1.next = tempNode;

        return head;
    }
}
