package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
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
        String inUpperCase = outputStream.toString().replaceAll("te","??");
        System.setOut(console);
        System.out.println(inUpperCase);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
