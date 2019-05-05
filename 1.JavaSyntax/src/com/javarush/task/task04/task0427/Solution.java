package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(reader.readLine());
        if (inputNumber < 1 || inputNumber > 999) {

        } else {
            if (inputNumber % 2 == 0) {
                System.out.print("четное ");
            } else {
                System.out.print("нечетное ");
            }

            if (inputNumber < 10) {
                System.out.println("однозначное число");
            } else if (inputNumber < 100) {
                System.out.println("двузначное число");
            } else if (inputNumber < 1000) {
                System.out.println("трехзначное число");
            }
        }
    }
}
