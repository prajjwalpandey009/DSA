package org.example.array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        insert(new int[][]{{1, 5}}, new int[]{1, 7});
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        int count = 0;
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                //interval is coming before new interval
                list.add(interval);
            } else if (newInterval[1] < interval[0]) {
                //interval is coming after the end of new interval
                break;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
            count++;
        }

        list.add(newInterval);

        while (count < intervals.length) {
            list.add(intervals[count]);
            count++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
