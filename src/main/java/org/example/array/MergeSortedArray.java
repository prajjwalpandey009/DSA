package org.example.array;

public class MergeSortedArray {
    public static void main(String[] args) {
        merge(new int[]{1, 3, 4, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int counter = 0;
        int[] merged = new int[nums1.length];
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                merged[counter] = nums1[p1];
                p1++;
            } else {
                merged[counter] = nums2[p2];
                p2++;
            }
            counter++;
        }
        while (p1 < m) {
            merged[counter] = nums1[p1];
            counter++;
            p1++;
        }

        while (p2 < n) {
            merged[counter] = nums2[p2];
            counter++;
            p2++;
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = merged[i];
        }
    }
}
