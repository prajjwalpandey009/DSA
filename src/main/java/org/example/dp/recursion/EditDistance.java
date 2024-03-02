package org.example.dp.recursion;


//Algo
//When you assume that  you are inserting element just increase the counter for second word
//It means the character is now added in before first word so  now check the next word in second word
//when you assume that you are deleting character just increase the counter for first word
//It means the character is now deleted from first word so now check the next word in first word

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length() + 1][word2.length() + 1];
        return solveMinimumDistance(word1, word2, 0, 0, dp);
    }

    private static int solveMinimumDistance(String word1, String word2, int i, int j, Integer[][] dp) {
        if (i > word1.length() && j > word2.length()) {
            return 0;
        }
        if (i == word1.length()) {
            //when word1.length reaches to end then how many character are left in word 2
            return word2.length() - j;
        }
        if (j == word2.length()) {
            //when word2.length reaches to end then how many character are left in word 1
            return word1.length() - i;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = solveMinimumDistance(word1, word2, i + 1, j + 1, dp);
        } else {
            //insert
            int insert = 1 + solveMinimumDistance(word1, word2, i, j + 1, dp);
            //delete
            int delete = 1 + solveMinimumDistance(word1, word2, i + 1, j, dp);
            //replace
            int replace = 1 + solveMinimumDistance(word1, word2, i + 1, j + 1, dp);
            return dp[i][j] = Math.min(Math.min(insert, delete), replace);
        }
    }
}
