package org.example.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
        //Algo
        //Sort the array
        //Add one and skip one
        //follow the same

        deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ans = new int[deck.length];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        int i = 0;
        int idx = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (i % 2 == 0) {
                ans[index] = deck[idx];
                idx++;
            } else {
                queue.add(index);
            }
            i++;
        }

        return ans;
    }
}
