package com.bo.lamdba.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author gpb
 * @date 2022/8/8 21:10
 */
@Data
@ToString
public class Student {

    private Integer id;

    private Integer age;

    private String name;

    private Date birthday;

    private String classNum;
}
