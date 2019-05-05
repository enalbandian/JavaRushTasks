package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

        try (FileReader reader = new FileReader(args[0])) {

            HashMap <String,Double> salary = new HashMap<>();

            StringBuilder sb = new StringBuilder();

            char[] toReadFile = new char[1024];

            while (reader.ready()) {
                reader.read(toReadFile);

                sb.append(toReadFile);
            }
            String res = sb.toString();
//            res = res.replaceAll("\\\\n","");

            res = res.replaceAll("\\r","");

            String[] lines = res.split("\\n");

            for (String s:
                 lines) {
                String[] temp = s.split(" ");
                salary.put(temp[0], Double.parseDouble(temp[1]));

            }

            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
