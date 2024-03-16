package org.example.heap;

import java.util.PriorityQueue;

public class MergeKLists {
    static class ListNode {
        int val;
        ListNode next;
    }

    public static void main(String[] args) {
        ListNode node = mergeKLists(new ListNode[]{null});
        System.out.println("Hii");
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                pq.add(node.val);
                node = node.next;
            }
        }
        if (pq.isEmpty()){
            return null;
        }

        ListNode listnode = new ListNode();
        ListNode curr = listnode;
        while (!pq.isEmpty()) {
            curr.val = pq.poll();
            if (pq.peek() != null) {
                curr.next = new ListNode();
            }
            curr = curr.next;
        }
        return listnode;
    }
}
