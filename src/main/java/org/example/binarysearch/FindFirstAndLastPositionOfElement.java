package org.example.binarysearch;

public class FindFirstAndLastPositionOfElement {

    public static void main(String[] args) {
        searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftIndex = findInLeftBound(nums, target);
        int rightIndex = findInRightBound(nums, target);
        return new int[]{rightIndex, leftIndex};
    }

    private static int findInRightBound(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        int firstIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                firstIndex = mid;

                //continuously check on left side
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return firstIndex;
    }

    private static int findInLeftBound(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        int secondIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                secondIndex = mid;

                //continuously check on right side
                lo = mid + 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return secondIndex;
    }
}
