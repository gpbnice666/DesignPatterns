package com.bo.behaviourPatterns.chainOfResponsibility;

import com.bo.behaviourPatterns.chainOfResponsibility.handler.AbstractLeaveHandler;
import com.bo.behaviourPatterns.chainOfResponsibility.handler.impl.DeptManagerLeaveHandler;
import com.bo.behaviourPatterns.chainOfResponsibility.handler.impl.DirectLeaderLeaveHandler;
import com.bo.behaviourPatterns.chainOfResponsibility.handler.impl.GManagerLeaveHandler;

/**
 * @author gpb
 */
public class Client {

    public static void main(String[] args) {
        LeaveRequest request = LeaveRequest.builder().leaveDays(20).name("小明").build();


        AbstractLeaveHandler directLeaderLeaveHandler = new DirectLeaderLeaveHandler("县令");
        AbstractLeaveHandler deptManagerLeaveHandler = new DeptManagerLeaveHandler("知府");
        AbstractLeaveHandler gManagerLeaveHandler = new GManagerLeaveHandler("京兆尹");

        directLeaderLeaveHandler.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);

        directLeaderLeaveHandler.handlerRequest(request);
    }

}
