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

        String aa = new String("a") + new String("b");
    }


}
