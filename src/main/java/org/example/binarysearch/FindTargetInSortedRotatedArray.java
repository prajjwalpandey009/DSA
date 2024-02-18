package org.example.binarysearch;


//Algorithium
//First find out the sorted part of array if not discard it
//then check if target is lies in the range or not
//if not increase the postion


public class FindTargetInSortedRotatedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {
        int lo = 0;
        int high = nums.length - 1;
        while (lo <= high) {
            int mid = lo + (high - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // checking the sorted part
            else if (nums[lo] <= nums[mid]) {

                //checking the range of target if lies than move towards it
                if (target >= nums[lo] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    //moved opposite of sorted
                    lo = mid + 1;
                }
            }
            // checking the sorted part
            else if (nums[mid] <= nums[high]) {

                //checking the range of target if lies than move towards it
                if (target >= nums[mid] && target <= nums[high]) {
                    lo = mid + 1;
                } else {
                    //moved opposite of sorted
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}


