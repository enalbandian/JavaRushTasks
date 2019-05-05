package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

        Map<String,String> m = new HashMap<String, String>();
//{name=Ivanov, country=Ukraine, city=Kiev, age=null}
        m.put("name","Ivanov");
        m.put("country", "Ukraine");
        m.put("city","Kiev");
        m.put("age", null);
        System.out.println(getQuery(m));

    }
    public static String getQuery(Map<String, String> params) {
        
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for (Map.Entry<String,String> map:
                params.entrySet() ) {

            if (map.getValue() == null) {
                continue;
            } else {
                if (sb.toString().length() > 0) {
                    sb.append(" and ");
                }
                //name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
                sb.append(map.getKey());
                sb.append(" = '");
                sb.append(map.getValue());
                sb.append("'");
            }

        }
        
        return sb.toString();
    }
}
