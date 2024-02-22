package org.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> maxHeap = null;
    PriorityQueue<Integer> minHeap = null;


    public MedianFinder() {
        maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
    }

    public void addNum(int num) {
        //Adding into max heap first
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else {
            maxHeap.add(num);
            if (maxHeap.size() <= minHeap.size()) {
                //if maxpeek is greater than min peak it means the sorting order is not correct
                if (maxHeap.peek() > minHeap.peek()) {
                    //polling max element from maxheap and pushing to min heap and doing vice-versa
                    //so we will get sorted order
                    int temp = maxHeap.poll();
                    maxHeap.add(minHeap.poll());
                    minHeap.add(temp);
                }
            } else {
                //max heap is greater extract the max number and add to min heap
                int maxNumber = maxHeap.poll();
                minHeap.add(maxNumber);
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() < minHeap.size()) {
            //In this case middle element will lie on min heap
            return minHeap.peek();
        } else if (maxHeap.size() == minHeap.size()) {
            int maxNum = maxHeap.peek();
            int minNum = minHeap.peek();
            return (maxNum + minNum) / 2.0;
        }
        return maxHeap.peek();
    }
}
