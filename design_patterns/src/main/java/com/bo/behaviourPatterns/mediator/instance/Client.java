package com.bo.behaviourPatterns.mediator.instance;

import com.bo.behaviourPatterns.mediator.instance.cutomerImpl.Buyer;
import com.bo.behaviourPatterns.mediator.instance.cutomerImpl.Seller;
import com.bo.behaviourPatterns.mediator.instance.mediumImpl.EstateMedium;

public class Client {

    public static void main(String[] args) {
        Medium md = new EstateMedium();    //房产中介
        Customer member1, member2;
        member1 = new Seller("张三(卖方)");
        member2 = new Buyer("李四(买方)");
        md.register(member1); //客户注册
        md.register(member2);
    }
}
