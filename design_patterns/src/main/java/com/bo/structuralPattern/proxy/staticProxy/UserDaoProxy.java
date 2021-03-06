package com.bo.structuralPattern.proxy.staticProxy;


import com.bo.structuralPattern.proxy.staticProxy.dao.IUserDao;

/**
 * @author gpb
 * 代理对象,静态代理
 */
public class UserDaoProxy implements IUserDao {


    private IUserDao target;

    public UserDaoProxy(IUserDao target){
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}
