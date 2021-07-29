package com.bo.createdPatterns.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author  implements Cloneable, Serializable {
    private String name;

    private String sex;

    private int age;

    @Override
    protected Author clone() throws CloneNotSupportedException {
        Object object=null;
        try {
            object = super.clone();
        }catch (Exception e){
            System.out.println("克隆失败");
        }
        return (Author)object;
    }
}
