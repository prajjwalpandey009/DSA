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
        ListNode currentNode = head.next;
        while (currentNode.next != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prev;

            //update
            prev = currentNode;
            currentNode = nextNode;
        }
        currentNode.next = prev;
        prev = currentNode;

        head.next = null;
        head = prev;
        return head;
    }
}
