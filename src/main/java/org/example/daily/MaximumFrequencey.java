package org.example.daily;

public class MaximumFrequencey {
    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
    }

    public static int maxFrequencyElements(int[] nums) {

        int[] bucket = new int[100];

        for (int i : nums) {
            bucket[i] = bucket[i] + 1;
        }

        int count = 0;
        int mx = 0;

        for (int i : bucket) {
            if (i > mx) {
                count = i;
                mx = i;
            } else if (i == mx) {
                count += i;
            }
        }

        return mx;

    }
}
