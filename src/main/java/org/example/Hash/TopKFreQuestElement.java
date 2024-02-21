package org.example.Hash;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFreQuestElement {

    public static void main(String[] args) {
        topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] arrayList = new List[nums.length + 1];
        map.forEach((key, val) -> {
            if (arrayList[val] == null) {
                arrayList[val] = new ArrayList<>();
                arrayList[val].add(key);
            } else {
                arrayList[val].add(key);
            }
        });

        int[] ans = new int[k];
        int count = 0;
        for (int i = arrayList.length - 1; i >= 0; i--) {
            if (arrayList[i] == null) {
                continue;
            }
            for (int in : arrayList[i]) {
                ans[count] = in;
                count++;
            }
            if (count == k) {
                break;
            }
        }
        return ans;
    }
}
