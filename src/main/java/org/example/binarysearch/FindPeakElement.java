package org.example.binarysearch;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{3, 4, 3, 2, 1}));
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 2] < nums[nums.length - 1]) return nums.length - 1;
        return solveFindPeakElement(nums, 0, nums.length - 1);
    }

    private static int solveFindPeakElement(int[] nums, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                return solveFindPeakElement(nums, mid + 1, high);
            } else {
                return solveFindPeakElement(nums, low, mid - 1);
            }
        }
        return -1;
    }
}
