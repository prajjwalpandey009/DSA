package org.example.daily;

public class CustomSortString {
    public static void main(String[] args) {
        customSortString("kqep", "pekeq");
    }

    public static String customSortString(String order, String s) {
        int[] chars = new int[27];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] = chars[s.charAt(i) - 'a'] + 1;
        }

        String ans = "";
        for (int i = 0; i < order.length(); i++) {
            if (chars[order.charAt(i) - 'a'] > 0) {
                while (chars[order.charAt(i) - 'a'] > 0) {
                    ans = ans + order.charAt(i);
                    chars[order.charAt(i) - 'a'] -= 1;
                }

            } else {
                break;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            while (chars[i] > 0) {
                ans = ans + (char) (i + 'a');
                chars[i] -= 1;
            }
        }
        return ans;
    }
}
