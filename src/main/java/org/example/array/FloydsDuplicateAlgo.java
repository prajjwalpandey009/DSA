package org.example.array;

public class FloydsDuplicateAlgo {
    public static void main(String[] args) {
        findDuplicate(new int[]{1, 3, 4, 2, 2});
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        //this step is for detecting of cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        //this step is for get the very first node which creates the cycle
        do {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);
        return slow;
    }
}
