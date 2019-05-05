package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader consoleReder = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = null;
        BufferedWriter fileWriter = null;
        try {
            fileReader = new BufferedReader(new FileReader(consoleReder.readLine()));
            fileWriter = new BufferedWriter(new FileWriter(consoleReder.readLine()));
            while (fileReader.ready()) {
                String temp = fileReader.readLine();
                temp = temp.replaceAll(",","");
                temp = temp.replaceAll("\\.","");
                temp = temp.replaceAll("\\.\\.\\.","");
                temp = temp.replaceAll("\\?","");
                temp = temp.replaceAll(";","");
                temp = temp.replaceAll("!","");
                temp = temp.replaceAll(":","");
                temp = temp.replaceAll("-","");
                temp = temp.replaceAll("\\p{Punct}","");
                fileWriter.write(temp);
               // fileWriter.write("\r\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (consoleReder != null) {
                    consoleReder.close();
                }
                if (fileReader != null) {
                    fileReader.close();
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
