package com.bo.spring.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class Users extends Model<Users> {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String name;

    private Integer age;

    private Integer one;

    private Date two;

}