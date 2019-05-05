package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),Charset.forName("Windows-1251")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8));
        String line;
        int i = 0;
        while ((line = br.readLine())!=null) {
            if (i++ != 0) {

                bw.write("\n");
            }
            byte[] buffer = line.getBytes("Windows-1251");
            String s = new String(buffer, "UTF-8");
            bw.write(s);

        }
        br.close();
        bw.close();
    }
}
