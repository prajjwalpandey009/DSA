package org.example.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k, 0, nums.length - 1, 0);
    }

    public static int solve(int[] nums, int k, int start, int end, int ans) {
        if (start >= end) {
            return ans;
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            set.add(nums[i]);
            list.add(nums[i]);
        }
        System.out.println(list);
        if (set.size() == k) {
            ans += 1;
        }

        int i_start = solve(nums, k, start, end - 1, ans);
        int i_end = solve(nums, k, start + 1, end, ans);

        return i_start + i_end;
    }

}
