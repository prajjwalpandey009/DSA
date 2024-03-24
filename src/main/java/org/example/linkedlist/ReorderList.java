package org.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        reorderList(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4)))));
    }

    public static void reorderList(ListNode head) {

        List<ListNode> list = new ArrayList<>();

        ListNode next = head;
        while (next != null) {
            list.add(next);
            next = next.next;
        }


        int size = list.size() / 2;
        int i = 0;
        int j = list.size() - 1;
        ListNode ans = head;
        while (size >= 0) {
            ListNode node = list.get(i).next;
            list.get(i).next = list.get(j);
            list.get(j).next = node;
            i++;
            j--;
            size--;
        }
        if (i - 1 == list.size() / 2) {
            list.get(i - 1).next = null;
        }
        System.out.println("Hii");
    }
}
