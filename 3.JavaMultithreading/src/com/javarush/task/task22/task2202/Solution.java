package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));


    }

    public static String getPartOfString(String string) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
        String[] strings = string.split(" ");

            for (int i = 1; i < 5; i++) {
                stringBuilder.append(strings[i]);
                if (i!=4) {
                    stringBuilder.append(" ");
                }
            }

        } catch (NullPointerException ex) {

                TooShortStringException e = new TooShortStringException();
                throw e;

        }catch (ArrayIndexOutOfBoundsException ex) {

            TooShortStringException e = new TooShortStringException();
            throw e;

        }


        return stringBuilder.toString();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
