package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        byte[][] a3 = new byte[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1}
        };
        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);

        System.out.println("count = " + count3 + ". Должно быть 5");
    }

    public static int getRectangleCount(byte[][] a) {

        int count = 0;

        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    //a[i][j] = 0;
                    count++;
                    int temp = i;

                    boolean mainFlag = true;
                    while (mainFlag) {
                        boolean flag = true;
                        while (flag) {
                            if (i != 0 && i == a[0].length) {
                                flag = false;
                                break;
                            } else if (a[i][j] == 1) {
                                a[i++][j] = 0;
                            } else {
                                flag = false;
                            }

                        }
                        i = temp;
                        if (j == a[j].length - 1 || a[i][++j] == 0) {
                            mainFlag = false;
                        }
                    } /*
                    flag = true;
                    while (flag) {
                        if (j != 0 && j == a[j].length - 1) {
                            flag = false;
                            break;
                        } else if (a[i][++j] == 1) {
                            a[i][j] = 0;
                        } else {
                            flag = false;
                        }

                    }*/
                    i = 0;
                    j = 0;
                }
            }
        }

        return count;
    }
}
