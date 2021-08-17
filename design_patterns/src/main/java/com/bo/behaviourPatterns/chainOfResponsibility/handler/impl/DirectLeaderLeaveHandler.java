package com.bo.behaviourPatterns.chainOfResponsibility.handler.impl;

import com.bo.behaviourPatterns.chainOfResponsibility.LeaveRequest;
import com.bo.behaviourPatterns.chainOfResponsibility.handler.AbstractLeaveHandler;

/**
 * @author gpb
 * 主管处理类
 */
public class DirectLeaderLeaveHandler extends AbstractLeaveHandler {

    public DirectLeaderLeaveHandler(String name){
        this.handlerName =name;
    }

    @Override
    public void handlerRequest(LeaveRequest request) {
        if (request.getLeaveDays() <= this.MIN) {
            System.out.println("直接主管：" + handlerName + ",已处理审批。");
        }
        if (null != this.nextHandler) {
            this.nextHandler.handlerRequest(request);
        }else{
            System.out.println("审批拒绝！");
        }
    }
}