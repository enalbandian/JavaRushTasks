package com.javarush.task.task19.task1914;

/*
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ourStream = new PrintStream(outputStream);
        System.setOut(ourStream);
        //estString testString = new TestString();
        testString.printSomething();
        String inUpperCase = outputStream.toString().replaceAll("\\r\\n","");
        String[] sArray = inUpperCase.split(" ");
        System.setOut(console);
        if (sArray[1].equals("+")) {
            System.out.println(inUpperCase + "" + (Integer.parseInt(sArray[0]) + Integer.parseInt(sArray[2])));
        } else if (sArray[1].equals("-")) {
            System.out.println(inUpperCase + "" + (Integer.parseInt(sArray[0]) - Integer.parseInt(sArray[2])));
        } else if (sArray[1].equals("*")) {
            System.out.println(inUpperCase + "" + (Integer.parseInt(sArray[0]) * Integer.parseInt(sArray[2])));
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

