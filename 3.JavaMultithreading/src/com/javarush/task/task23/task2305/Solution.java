package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] s = new Solution[2];
        for (int i = 0; i < 2; i++) {
            s[i] = new Solution();
            for (int j = 0; j < 2; j++) {
                s[i].innerClasses[j] = s[i].new InnerClass();

            }

        }
        return s;
    }

    public static void main(String[] args) {

    }
}
