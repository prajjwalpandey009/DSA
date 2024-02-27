package org.example.dp.recursion;

public class ClimbingStair {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }
        int onestep = climbStairs(n - 1);
        int twostep = climbStairs(n - 2);
        return onestep + twostep;
    }
}
