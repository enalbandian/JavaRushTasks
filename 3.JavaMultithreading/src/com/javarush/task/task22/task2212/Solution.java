package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) {
            return false;
        }
       /* if (telNumber.contains("(") && telNumber.matches(".*[0-9]+\\(.*")) {
            System.out.println();
        }*/
        boolean res = false;
        for (int i = 0; i < 2; i++) {
            if (telNumber.matches(".*--.*") || telNumber.toCharArray()[0] == '-' || telNumber.matches(".*-$")) {
                return false;
            }
            telNumber = telNumber.replaceFirst("-", "");
        }

        if (telNumber.contains("(") && telNumber.matches(".*[0-9]+\\([0-9]{3}\\).*")) {
            telNumber = telNumber.replaceFirst("\\(", "");
            telNumber = telNumber.replaceFirst("\\)", "");
        }
        if (telNumber.toCharArray()[0] == '+') {
            if (telNumber.length() != 13) {
                return false;
            } else {
                res = true;
                telNumber = telNumber.replaceFirst("\\+", "");
            }
        }
        if ((res && telNumber.length() == 12) || (!res && telNumber.length() == 10) && telNumber.matches("[0-9]+")) {
            res = true;
        }


        return res;

    }


    public static void main(String[] args) {

        System.out.println(checkTelNumber("+380501234567")); //     - true

        System.out.println(checkTelNumber("+38(050)1234567"));//   - true

        System.out.println(checkTelNumber("+38050123-45-67"));//         - true

        System.out.println(checkTelNumber("050123-4567"));// - true

        System.out.println(checkTelNumber("+38)050(1234567")); //     - false

        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));//        - false

        System.out.println(checkTelNumber("050õõõ4567"));// - false

        System.out.println(checkTelNumber("050123456")); //- false

        System.out.println(checkTelNumber("(0)501234567"));// - false

        System.out.println(checkTelNumber(""));

        System.out.println(checkTelNumber(null));


    }
}
