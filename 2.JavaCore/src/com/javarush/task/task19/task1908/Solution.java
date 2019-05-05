package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = null;
        BufferedWriter writer = null;
        try {
            fileReader = new BufferedReader(new FileReader(reader.readLine()));
            writer = new BufferedWriter(new FileWriter(reader.readLine()));
            StringBuilder sb = new StringBuilder();
            boolean isFirst = true;
            int previousChar = 99999;
            while (fileReader.ready()) {

                String line = fileReader.readLine();
                String[] array = line.split(" ");

                for (int i = 0; i < array.length; i++) {
                    try {
                        int temp = Integer.parseInt(array[i]);
                        if (!isFirst) {
                            writer.write(" ");
                        }
                        writer.write(String.valueOf(temp));
                        isFirst = false;


                    } catch (NumberFormatException e) {

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
