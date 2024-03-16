package org.example.prefix;

public class PartitionArrayInto3EqualSubArray {

    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {

        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }


        if (prefix[arr.length - 1] % 3 != 0) {
            return false;
        }

        int count = 0;
        int sumForSubArray = prefix[arr.length - 1] / 3;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0 && prefix[i] == sumForSubArray) {
                //reached the sum first time
                count++;
            } else if (count == 1 && prefix[i] == 2 * sumForSubArray) {
                //reached the sum second time
                count++;
            } else if (count == 2 && prefix[i] == 3 * sumForSubArray) {
                //reached the sum third time
                if (i == arr.length - 1) {
                    //reached in th end of array
                    return true;
                }
            }
        }

        return false;
    }
}
