package com.bo.structuralPattern.facade.pojo;

import com.bo.structuralPattern.facade.pojo.TeaWater;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Man {
    private String name;
    public Man(String name) {
        this.name = name;
    }
    public void drink(TeaWater teawater) {
        System.out.println(name + " 喝了" + teawater.getTeaWater());
    }
}