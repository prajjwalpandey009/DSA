package org.example.permutation;

public class Permutation {
    public static void main(String[] args) {
        doPermutation(new char[]{'a', 'b', 'c'}, 0);
    }

    public static void doPermutation(char[] arr, int start) {
        if (start >= arr.length) {
            System.out.println(arr);
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            doPermutation(arr, start + 1);
            swap(arr, start, i);
        }

    }

    private static void swap(char[] arr, int start, int i) {
        char temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
    }
}
