package com.bo.createdPatterns.prototype.copy;


import java.util.Random;


public class Client {
    private static Integer MAX_COUNT=6;

    public static void main(String[] args)  {

        Thing thing = new Thing("aaa");
        Thing clone = thing.clone();
        System.out.println(thing);
        System.out.println(clone);
        System.out.println(thing==clone);
        System.out.println(thing.hashCode());
        System.out.println(clone.hashCode());

//        int i=0;
//        Mail mail = new Mail(new AdvTemplate());
//
//        mail.setTail("XX银行版权所有");
//        while(i<MAX_COUNT){
//            mail.setAppellation(getRandString(5));
//            mail.setReceiver(getRandString(5)+"@"+getRandString(8)+".com");
//            sendMail(mail);
//            i++;
//        }
    }

    public static void sendMail(Mail mail){
        System.out.println("标题:"+mail.getSubject()+"收件人："+mail.getReceiver()+"    发送 成功");
    }

    public static String getRandString(int maxLength){
        String source ="zxcvbnmlkjhgfdsaqwertyuiopPOIUYTREWQASDFGHJKLMNBVCXZ";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i=0;i<maxLength;i++){
            sb.append(source.charAt(random.nextInt(source.length())));
        }
        return sb.toString();
    }
}
