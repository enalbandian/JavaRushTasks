package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        BufferedWriter fileWritter = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ourStream = new PrintStream(outputStream);
        System.setOut(ourStream);
        FileOutputStream stream = null;
        try {

            stream = new FileOutputStream(reader.readLine());
                    //estString testString = new TestString();
                    testString.printSomething();
            String inUpperCase = outputStream.toString();
            System.setOut(console);
            stream.write(inUpperCase.getBytes());

            System.out.println(inUpperCase);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
                if (null != reader) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

