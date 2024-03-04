package org.example.binarysearch;

public class FindTargetElementInRotatedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //checking if left part is sorted or not
            else if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target <= nums[mid]) {
                    //its means that target lies in left side
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            //checking if right part is sorted or not
            else if (nums[mid] <= nums[hi]) {
                if (nums[mid] <= target && target <= nums[hi]) {
                    //It means that target lies on right side
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
