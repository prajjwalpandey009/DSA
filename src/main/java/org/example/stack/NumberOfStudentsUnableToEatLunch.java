package org.example.stack;

public class NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        //Algo
        countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1});
    }

    public static int countStudents(int[] students, int[] sandwiches) {

        int count_0 = 0;
        int count_1 = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                count_0 += 1;
            } else {
                count_1 += 1;
            }
        }

        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0) {
                if (count_0 > 0) {
                    count_0--;
                } else {
                    break;
                }
            } else {
                if (count_1 > 0) {
                    count_1--;
                } else {
                    break;
                }
            }
        }
        return count_0 + count_1;
    }
}
