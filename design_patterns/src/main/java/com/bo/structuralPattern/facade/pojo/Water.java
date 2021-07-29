package com.bo.structuralPattern.facade.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Water {
    private int temperature;    // 温度
    private int capacity;       // 容量
    public Water() {
        this.temperature = 0;
        this.capacity = 10;
    }
    // 省略...
}    