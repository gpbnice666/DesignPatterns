package com.bo.structuralPattern.proxy.jdkProxy.dao.impl;

import com.bo.structuralPattern.proxy.jdkProxy.dao.IUserDao;

/**
 *
 * @author gpb
 * 接口实现
 * 目标对象
 *
 */
public class UserDao implements IUserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}