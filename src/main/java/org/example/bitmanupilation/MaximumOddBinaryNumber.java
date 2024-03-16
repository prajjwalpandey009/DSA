package org.example.bitmanupilation;

public class MaximumOddBinaryNumber {

    public static void main(String[] args) {
        //To make greatest odd string we have to follow the approach
        //To make greatest we have to add maximum possible 1 in start of string
        //and extract one 1 in starting before adding so we can add it in last and
        //make the whole string as odd
        System.out.println(maximumOddBinaryNumber("0101"));
    }

    public static String maximumOddBinaryNumber(String s) {
        int[] count = new int[2];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count[0] += 1;
            } else {
                count[1] += 1;
            }
        }

        String odd = "1";
        count[1] -= 1;

        String ans = "";

        while (count[1] + count[0] > 0) {
            if (count[1] > 0) {
                ans = ans + "1";
                count[1] -= 1;
            } else {
                ans = ans + "0";
                count[0] -= 1;
            }
        }
        return ans + odd;
    }
}
