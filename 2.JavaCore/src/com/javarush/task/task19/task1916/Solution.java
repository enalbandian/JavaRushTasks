package com.javarush.task.task19.task1916;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader firstFileReader = null;
        BufferedReader secondFileReader = null;
        try {
            firstFileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
            secondFileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
            //read all lines from first file to ArrayList
            List<String> rowsFirstFile = new ArrayList<String>();
            while (firstFileReader.ready()) {
                rowsFirstFile.add(firstFileReader.readLine());
            }
            //read all lines from second file to ArrayList
            List<String> rowsSecondFile = new ArrayList<String>();
            while (secondFileReader.ready()) {
                rowsSecondFile.add(secondFileReader.readLine());
            }
            int count = 0;

            if (rowsFirstFile.size() >= rowsSecondFile.size()) {
                for (int i = 0; i < rowsFirstFile.size(); i++) {
                    if (i < rowsSecondFile.size() + count) {
                        String temp1 = rowsFirstFile.get(i);
                        String temp2 = rowsSecondFile.get(i);
                        String temp3 = "1";
                        System.out.println(temp1.equals(temp2));
                        System.out.println(temp2.equals(temp3));
                        System.out.println(temp1.equals(temp3));
                        System.out.println(temp2.getBytes() + " " + temp1.getBytes() + " " + temp3.getBytes());
                        // System.out.println(rowsFirstFile.get(i) + " " + rowsSecondFile.get(i+ count));
                        if ((rowsFirstFile.get(i)).equals(rowsSecondFile.get(i))) {
                            lines.add(new LineItem(Type.SAME, rowsFirstFile.get(i)));
                        } else if (rowsFirstFile.get(i).equals(rowsFirstFile.get(i + count + 1))) {
                            lines.add(new LineItem(Type.ADDED, rowsSecondFile.get(i + count)));
                            count++;
                        } else {
                            lines.add(new LineItem(Type.REMOVED, rowsFirstFile.get(i)));
                            count--;
                        }
                    } else {
                        lines.add(new LineItem(Type.REMOVED, rowsFirstFile.get(i + count)));
                    }
                }
            } else {
                for (int i = 0; i < rowsSecondFile.size(); i++) {
                    if (i < rowsFirstFile.size() + count) {
                        if (rowsFirstFile.get(i).equals(rowsSecondFile.get(i))) {
                            lines.add(new LineItem(Type.SAME, rowsFirstFile.get(i)));
                        } else if (rowsFirstFile.get(i).equals(rowsSecondFile.get(i + 1 + count))) {
                            lines.add(new LineItem(Type.ADDED, rowsSecondFile.get(i + count)));
                            count++;
                        } else {
                            lines.add(new LineItem(Type.REMOVED, rowsFirstFile.get(i)));
                            count--;
                        }
                    } else {
                        lines.add(new LineItem(Type.ADDED, rowsSecondFile.get(i + count)));
                    }
                }


            }
            for (int i = 0; i < lines.size(); i++) {

                System.out.println(lines.get(i).type + " " + lines.get(i).line);
            }
        } catch (
                FileNotFoundException e)

        {
            e.printStackTrace();
        } catch (
                IOException e)

        {
            e.printStackTrace();
        } finally

        {
            try {
                if (firstFileReader != null) {
                    firstFileReader.close();
                }
                if (secondFileReader != null) {
                    secondFileReader.close();
                }
                if (consoleReader != null) {
                    consoleReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
