package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        /*
        UA Ukraine
RU Russia
CA Canada
         */
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
/*
        DataAdapter adapter = new DataAdapter(new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        }, new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        });

        System.out.println(adapter.getCompany());
        System.out.println(adapter.getContactFirstName());
        System.out.println(adapter.getContactLastName());
        System.out.println(adapter.getCountryCode());
        System.out.println(adapter.getDialString());*/
    }

    public static class DataAdapter implements RowItem {

        private Customer customer;
        private  Contact contact;

        public DataAdapter(Customer customer, Contact contact) {

            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            String code = null;
            for (String codeTemp :
                    countries.keySet()) {
                if (countries.get(codeTemp).equals(customer.getCountryName())) {
                    code = codeTemp;
                }
            }
            return code;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }

        @Override
        public String getDialString() {
            StringBuilder sb = new StringBuilder();
            sb.append("callto://");
            sb.append(contact.getPhoneNumber().split("\\(")[0]);
            sb.append(contact.getPhoneNumber().split("\\(")[1].split("\\)")[0]);
            sb.append(contact.getPhoneNumber().split("\\)")[1].split("-")[0]);
            sb.append(contact.getPhoneNumber().split("-")[1]);
            sb.append(contact.getPhoneNumber().split("-")[2]);
            return sb.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}