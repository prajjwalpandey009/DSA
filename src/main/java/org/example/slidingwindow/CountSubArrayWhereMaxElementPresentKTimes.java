package org.example.slidingwindow;

import java.util.Arrays;

public class CountSubArrayWhereMaxElementPresentKTimes {

    //refer with code story n-j concept
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
    }

    public static long countSubarrays(int[] nums, int k) {
        int mx_n = Arrays.stream(nums).max().getAsInt();
        int mx_c = 0;
        int res = 0;

        int r = 0;
        int l = 0;

        while (r < nums.length) {
            if (nums[r] == mx_n) {
                mx_c += 1;
            }

            while (mx_c >= k) {
                //Adding all the possible subset from last index
                res += nums.length - r;

                //start shrinking the window and remove max_c if max element matches
                if (nums[l] == mx_n) {
                    mx_c -= 1;
                }
                //increase the pointer of left till we max count frequency is not less than desired frequency
                l++;
            }

            //increase the pointer of right
            r++;
        }

        return res;
    }
}
