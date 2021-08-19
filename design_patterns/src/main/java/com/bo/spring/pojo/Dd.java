package com.bo.spring.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Dd extends Model<Dd> {

private static final long serialVersionUID=1L;

    private String a;

    private Date ab;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}