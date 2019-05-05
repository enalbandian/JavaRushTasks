package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FileWriter write = null;
        FileReader reader = null;
        BufferedReader bdReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            //Переменные для чтения и записи
            reader = new FileReader(bdReader.readLine());
            write = new FileWriter(bdReader.readLine());
            for (int i = 0; reader.ready(); i++) {
                if (i%2 != 0) {
                    write.write(reader.read());
                }
                else {
                    reader.read();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (write!= null) {
                try {
                    write.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } if (bdReader != null) {
                try {
                    bdReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
