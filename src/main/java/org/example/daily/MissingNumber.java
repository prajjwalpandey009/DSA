package org.example.daily;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    public static int missingNumber(int[] nums) {
        boolean[] bool = new boolean[nums.length + 1];
        for (int i : nums) {
            bool[i] = true;
        }
        for (int i = 0; i < bool.length; i++) {
            if (bool[i] == false) {
                return i;
            }
        }
        return 0;
    }
}
