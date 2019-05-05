package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = null;
        BufferedWriter fileWriter = null;
        try {
            fileReader = new BufferedReader(new FileReader(consoleReader.readLine())) ;
            fileWriter = new BufferedWriter(new FileWriter(consoleReader.readLine())) ;
            while (fileReader.ready()) {
                String symvol = fileReader.readLine();
                fileWriter.write(symvol.replaceAll("\\.", "!"));
                fileWriter.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (consoleReader != null) {
                    consoleReader.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}