package org.example.binarysearch;


//Algo
//Just need to find that potential pivot point where left is greater than mid as well
// as right is also is greater than mid
//is also greater

//We can also check that if low is less than high the directly return low
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {

        System.out.println(findMin(new int[]{2, 1}));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int min = Integer.MAX_VALUE;
        int lo = 0;
        int high = nums.length - 1;

        while (lo <= high) {
            int mid = lo + (high - lo) / 2;

            if (nums[lo] <= nums[high]) {
                min = Math.min(nums[lo], min);
                break;
            } else if ((mid > lo && nums[mid - 1] > nums[mid]) && nums[mid] < nums[mid + 1]) {
                min = Math.min(nums[mid], min);
                break;
            } else if (nums[lo] <= nums[mid]) {
                lo = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return min;
    }
}
