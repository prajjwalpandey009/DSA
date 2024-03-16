package org.example.prefix;

public class PivotInteger {
    public static void main(String[] args) {
        System.out.println(pivotInteger(4));
    }

    public static int pivotInteger(int n) {
        int prefix = 0;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        for (int i = 1; i <= n; i++) {
            prefix += i;
            if (total - prefix + i == prefix) {
                return i;
            }
        }
        return -1;

    }
}
