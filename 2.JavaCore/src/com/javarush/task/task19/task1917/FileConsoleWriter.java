package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter  {

    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for (char c:
             cbuf) {
            System.out.print(c);

        }
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        char[] newcbuf = new char[len];
        for (int i = 0; i < len; i++) {
            newcbuf[i] = cbuf[i+off];
        }
        for (char c:
             newcbuf) {
            System.out.print(c);
        }
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public void write(String s,int off, int len) throws IOException {
        fileWriter.write(s, off, len);
        System.out.println(s.substring(off,len+off));
    }



    public static void main(String[] args) {

    }

}
