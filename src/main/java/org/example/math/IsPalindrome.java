package org.example.math;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
