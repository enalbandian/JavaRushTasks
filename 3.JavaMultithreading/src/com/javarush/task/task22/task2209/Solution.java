package com.javarush.task.task22.task2209;

import java.io.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
        try (BufferedReader brConsole = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader br = new BufferedReader(new FileReader(brConsole.readLine()))) {
            String line = br.readLine();
            //String[] words = line.split(" ");
            StringBuilder result = getLine(line.split(" "));
            System.out.println(result.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder[] sb = new StringBuilder[words.length];
        int ml = 0;
        for (int i = 0; i < words.length; i++) {
            sb[i]=new StringBuilder("");
        }
        for (int i = 0; i < sb.length; i++) {
            sb[i].append(words[i]);
            int[] useNumber = new int[words.length];
            for (int j = 0; j <words.length; j++) {
                useNumber[j] = -1;
            }
            char lastLetter = words[i].toUpperCase().toCharArray()[words[i].length()-1];
            for (int j = 0; j < words.length; j++) {
                for (int k = 0; k < words.length; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (lastLetter == words[k].toUpperCase().toCharArray()[0]) {
                        int l=0;
                        for (l = 0; l < useNumber.length; l++) {
                            if (useNumber[l] == k) {
                                break;
                            }
                        }
                        if (l == useNumber.length) {
                            sb[i].append(" ");
                            sb[i].append(words[k]);
                            lastLetter = words[k].toUpperCase().toCharArray()[words[k].length()-1];
                            for (int m = 0; m < useNumber.length; m++) {
                                if (useNumber[m] == -1) {
                                    useNumber[m] = k;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (i>0) {
                if (sb[i].length() > sb[ml].length()) {
                    ml = i;
                }
            }
        }


        return sb[ml];
    }
}
