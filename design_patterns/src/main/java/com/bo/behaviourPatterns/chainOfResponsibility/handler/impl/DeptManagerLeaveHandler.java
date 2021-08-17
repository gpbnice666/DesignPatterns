package com.bo.behaviourPatterns.chainOfResponsibility.handler.impl;

import com.bo.behaviourPatterns.chainOfResponsibility.LeaveRequest;
import com.bo.behaviourPatterns.chainOfResponsibility.handler.AbstractLeaveHandler;

/**
 * @description: 部门经理处理类
 * @author: gpb
 */
public class DeptManagerLeaveHandler extends AbstractLeaveHandler {

    public DeptManagerLeaveHandler(String name){
        this.handlerName = name;
    }

    @Override
    public void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays() > this.MIN && request.getLeaveDays() <= this.MIDDLE){
            System.out.println("部门经理:" + handlerName + ",已经处理;流程结束。");
        }
        if(null != this.nextHandler){
            this.nextHandler.handlerRequest(request);
        }else{
            System.out.println("审批拒绝！");
        }
    }
}