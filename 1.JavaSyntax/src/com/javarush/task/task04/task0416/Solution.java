package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double t = Double.parseDouble(reader.readLine());
        if (t%5.0 < 3.0) {
            System.out.println("зелёный");
        } else if ((t%5.0 < 4.0)) {
            System.out.println("желтый");
        } else {
            System.out.println("красный");
        }
    }
}