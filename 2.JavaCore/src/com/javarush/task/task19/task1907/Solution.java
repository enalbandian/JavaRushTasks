package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        BufferedReader reader = null;
        FileReader fileReader = null;
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileReader = new FileReader(reader.readLine());
            StringBuilder sb = new StringBuilder();
            while (fileReader.ready()) {
                char simvol = (char) fileReader.read();
                if (simvol != '!' && simvol != '?' && simvol != '.' && simvol != ',' && simvol != ' '
                        && simvol != '\r' && simvol != '\n') {
                    sb.append(simvol);
                } else {

                    if (sb.toString().equalsIgnoreCase("world")) {
                        count++;
                    }
                    sb = new StringBuilder();
                }
            }
            if (sb.toString().equals("world")) {
                count++;
            }
            System.out.println(count);
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
        }
    }
}
