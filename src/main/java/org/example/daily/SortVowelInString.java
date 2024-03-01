package org.example.daily;

import java.util.PriorityQueue;

public class SortVowelInString {
    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
    }

    public static String sortVowels(String s) {

        PriorityQueue<Character> pq = new PriorityQueue<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
            || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                pq.add(ch);
            }
        }

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                    || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                ans = ans + pq.poll();
            } else {
                ans = ans + ch;
            }
        }

        return ans;

    }
}
