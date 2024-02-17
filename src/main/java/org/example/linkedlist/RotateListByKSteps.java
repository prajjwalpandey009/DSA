package org.example.linkedlist;

public class RotateListByKSteps {
    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3,
//                new ListNode(4, new ListNode(5, null)))));

//        ListNode listNode = new ListNode(1, new ListNode(2));

        ListNode listNode = new ListNode(0, new ListNode(1, new ListNode(2)));
        rotateRight(listNode, 1);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        //find the length
        ListNode lenNode = head;
        while (lenNode.next != null) {
            lenNode = lenNode.next;
            length++;
        }
        length++;

        //Find the actual valid rotation
        k = k % length;

        //rotation is meaningless
        if (k == 0) {
            return head;
        }

        //Reach to the kth node

        //use to two pointer approach to reach K node;
        ListNode p1 = head;
        ListNode p2 = head;
        int count = 0;
        while (p1.next != null) {
            p1 = p1.next;

            //First pointer reaches to k
            if (k <= count) {
                //start increasing the pointer p2 also to maintain gap
                p2 = p2.next;
            }
            count++;
        }

        //separate the list from p2 position
        ListNode afterP2Node = p2.next;

        //removed all links from p2 to make it as end
        p2.next = null;

        //attach afterNodeP2 to head
        ListNode endNode = afterP2Node;
        while (endNode.next != null) {
            endNode = endNode.next;
        }
        endNode.next = head;
        return afterP2Node;
    }
}
