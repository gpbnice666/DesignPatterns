package com.bo.string;

public class StringTest {
    public static void main(String[] args) {
        String str = new String("1");
        str.intern();
        String str1 = "1";
        System.out.println(str == str1);

        String str2 = new String("1") + new String("1");
        str2.intern();
        String str3 = "11";
        System.out.println(str2 == str3);
        System.out.println(str2 == str2.intern());

        String aa = new String("a") + new String("b");

        String str4 = new StringBuffer("ja").append("va").toString();
        String str5 = "java";
        System.out.println(str4 == str4.intern());
        Object intern = str4.intern();
        System.out.println(intern.toString());
        System.out.println((Object)str4.toString());


        ThreadLocal<StringTest> threadLocal = new ThreadLocal();
    }


}
