package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    private static class ReadFileThread extends Thread implements ReadFileInterface {

        String name;
        String content;


        @Override
        public void setFileName(String fullFileName) {
            this.name = fullFileName;
        }

        @Override
        public String getFileContent() {

            return content;
        }


        @Override
        public void start() {
            run();
        }

        @Override
        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader(name));
                String temp;
                try {
                    while ((temp = fileReader.readLine())!= null) {
                        sb.append(temp);
                        sb.append(" ");
                    }
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
                }
                content = sb.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    //add your code here - добавьте код тут
}
