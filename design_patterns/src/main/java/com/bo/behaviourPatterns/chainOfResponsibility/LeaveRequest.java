package com.bo.behaviourPatterns.chainOfResponsibility;

import lombok.*;

/**
 * @author gpb
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LeaveRequest {

    /**天数*/
    private int leaveDays;

    /**姓名*/
    private String name;

}
