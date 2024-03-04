package org.example.linkedlist;

//Algo reverse the linked list by using two variable
//I have taken 3 pointers (prev, current, next);
//updating prev with head
//current with head.next;
//next with current.next;
//now set current.next with prev so pointing is reverse
//again set prv , current and next;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseList(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {
            ListNode next = curr.next;
            curr.next = prev;

            //update the previous and current
            prev = curr;
            curr = next;
        }

        //When reached to last node
        curr.next = prev;

        //In starting we haven't set the null in head so now it present in last so set it null
        head.next = null;

        return curr;
    }
}
