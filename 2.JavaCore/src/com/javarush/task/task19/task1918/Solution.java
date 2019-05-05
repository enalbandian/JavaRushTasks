package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int countIntoTags = 0;
    static int countTagsToSkip = 0;


    public static void main(String[] args) {


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(reader.readLine())) {

            // reader.close();

            char[] buf = new char[1024];

            StringBuilder builder = new StringBuilder();

            builder.append("");

            while (fileReader.ready()) {

                fileReader.read(buf);

                builder.append(buf);
            }


            String[] temp = builder.toString().split(args[0]);

            toSearchTag(temp, args[0]);

            // fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

    private static void toSearchTag(String[] temp, String arg) {

        for (int i = countTagsToSkip+1; i < temp.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            if (i==0) {} else {
                char [] cTmp = temp[i-1].toCharArray();
                if (cTmp[cTmp.length-1] == '/') {
                    continue;
                }
            }
            sb.append("<");
            sb.append(arg);
            sb.append(temp[i]);
            char[] cTmp = sb.toString().toCharArray();

            if (cTmp[cTmp.length - 1] !='/') {
                countIntoTags++;
                int count = 1;
                while (countIntoTags !=-1) {
                    sb.append(arg);
                    sb.append(temp[i+count]);
                    count++;
                    cTmp = sb.toString().toCharArray();
                    if (cTmp[cTmp.length - 1] !='/') {
                        countIntoTags++;
                        count++;
                    } else {
                        countIntoTags--;
                    }
                }
                countIntoTags = 0;
            }
            sb.append(arg);
            sb.append(">");
            String res = sb.toString();
            //res = res.replaceAll("\\r","");
            //res = res.replaceAll("\\n","");
            System.out.println(res);
        }


    }
}
