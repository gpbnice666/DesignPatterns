package com.bo.spring;

import org.springframework.context.ApplicationContext;

import java.util.StringJoiner;

public class BeanApp {
    public static void main(String[] args) {
        String str = "a";
        String str1 = "b";
        String str3 = "ab";
        String str4 = (str + str1).intern();
        String str5 = "a" + str1;
        System.out.println(str4 == str3);
        System.out.println(str5 == str3);
        StringJoiner stringJoiner;
//        ApplicationContext applicationContext = null;
//        applicationContext.getBean("");
    }
}
