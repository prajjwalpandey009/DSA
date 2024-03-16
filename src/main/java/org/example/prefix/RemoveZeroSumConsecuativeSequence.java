package org.example.prefix;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecuativeSequence {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // removeZeroSumSublists(new ListNode(1, new ListNode(2, new ListNode(-3, new ListNode(3, new ListNode(1))))));
        removeZeroSumSublists(new ListNode(1, new ListNode(-1)));
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int prefixsum = 0;

        ListNode curr = dummy;
        while (curr != null) {
            //Calculate prefix sum at every node
            prefixsum += curr.val;

            //if same prefix sum available in map it means that consecutive sum is 0
            if (map.get(prefixsum) != null) {

                deleteConsecutiveValueWhoseSumIsZero(map, prefixsum, curr);
            } else {
                map.put(prefixsum, curr);
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    private static void deleteConsecutiveValueWhoseSumIsZero(Map<Integer, ListNode> map, int prefixsum, ListNode curr) {
        //get the previous node from map
        ListNode start = map.get(prefixsum);

        //take one temporary node to start
        ListNode temp = start;


        int currps = prefixsum;

        //calculating next sum and removing it from map
        //do it untill you temp reaches to current
        while (temp != curr) {
            temp = temp.next;
            currps += temp.val;

            if (temp != curr) {
                map.remove(currps);
            }
        }
        //In final de-link all those previous node from start
        start.next = curr.next;
    }
}
