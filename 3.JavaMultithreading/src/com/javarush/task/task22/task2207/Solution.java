package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader fr = new BufferedReader(new FileReader(bufferedReader.readLine()));
           // BufferedReader fr = new BufferedReader(new FileReader("C:\\Users\\Eduard Nalbandian\\Desktop\\test.txt"));
            String l;
            List<String> words = new ArrayList<>();
            while ( (l = fr.readLine()) != null) {
                String[] arWords = l.split(" ");
                for (int i = 0; i < arWords.length; i++) {
                    words.add(arWords[i]);
                }
            }

            for (int i = 0; i < words.size()-1; i++) {
                for (int j = i+1; j < words.size(); j++) {
                    Pair p = new Pair();
                    p.first = words.get(i);
                    StringBuilder sb = new StringBuilder(words.get(j));

                    p.second = sb.reverse().toString();
                    if (p.equals(p)) {
                        int k;
                        for (k = 0; k < result.size(); k++) {
                            if (p.first.equals(result.get(k).first)) {
                                break;
                            }
                        }
                        if (k == (result.size())) {
                            p.second = sb.reverse().toString();
                            result.add(p);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).first + " " + result.get(i).second);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
         //   if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.first) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
