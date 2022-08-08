package com.bo.demo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gpb
 * @date 2021/12/13 12:16
 */
public class ListDemo {

    public static void main(String[] args) {
        ArrayList<String> contain = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("123abccd");
        list.add("abcdc123");
        list.add("1234abc");
        list.add("ab1234cd");
        String regEx="[^0-9]";
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size()-i-1; j ++) {
                Pattern p = Pattern.compile(regEx);
                String a = p.matcher(list.get(i)).replaceAll("").trim() ;
                String b = p.matcher(list.get(j)).replaceAll("").trim() ;
                if(a.equals(b)){
                    contain.add(list.get(j));
                }
            }
        }
        list.removeAll(contain);
        System.out.println(list);
    }

}
