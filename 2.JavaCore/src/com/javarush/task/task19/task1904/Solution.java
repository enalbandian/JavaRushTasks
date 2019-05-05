package com.javarush.task.task19.task1904;

/*
И еще один адаптер
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Eduard Nalbandian\\Desktop\\test.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(scanner.hasNextLine());

        try {
            System.out.println(new PersonScannerAdapter(scanner).read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        @Override
        public Person read() throws IOException {
            String sPerson = fileScanner.nextLine();
          //  sPerson = fileScanner.next();
            String[] sPersonArray = sPerson.split(" ");
            //Иванов Иван Иванович 31 12 1950
            Date date;
            date = new Date(Integer.parseInt(sPersonArray[5]),Integer.parseInt(sPersonArray[4]),Integer.parseInt(sPersonArray[3]));

            Person person = new Person(sPersonArray[1],sPersonArray[2],sPersonArray[0],date);
            /*
            this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
             */
            return person;
        }

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
