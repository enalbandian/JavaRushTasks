package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(reader.readLine());
        if (inputNumber == 0) {
            System.out.println("ноль");
        }
        else {
            if (inputNumber > 0) {
                System.out.print("положительное ");
            } else {
                System.out.print("отрицательное ");
            }
            if (inputNumber%2 == 0) {
                System.out.println("четное число");
            } else {
                System.out.println("нечетное число");
            }
        }
    }
}
