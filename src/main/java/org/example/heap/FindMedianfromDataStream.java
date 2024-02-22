package org.example.heap;

//Algo
//To find median list should be sorted and its result is middlevalue/2 in case of odd
//In case of odd number median is sum of two middle number / 2 in case of even

//Approach is like we will create two heap max and min heap
//maxheap is always <= mean heap
//if we have to find the median just check if min heap is larger than maxheap so poll from min heap and
//you have the middle number just divide that number by 2 and that is your answer
//if heap size of max and mean both is equal
//its means that it is even condition and poll one element from both the heap and sum it and then divide by two
public class FindMedianfromDataStream {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
    }


}
