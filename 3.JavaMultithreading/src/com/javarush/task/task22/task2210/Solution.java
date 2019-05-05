package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")) );
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer s = new StringTokenizer(query,delimiter);
        String[] answer = new String[s.countTokens()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = s.nextToken();
        }
        return answer;
    }
}
