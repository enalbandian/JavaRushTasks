package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        /*
        для первой четверти a>0 и b>0;
для второй четверти a<0 и b>0;
для третьей четверти a<0 и b<0;
для четвертой четверти a>0 и b<0.
         */
        if (a>0 && b>0) {
            System.out.println("1");
        } else if (a<0 && b>0) {
            System.out.println("2");
        } else if (a < 0 && b < 0) {
            System.out.println("3");
        } else if (a > 0 && b < 0) {
            System.out.println("4");
        }
    }
}
