package com.bo.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gpb
 * @date 2021/12/13 12:46
 */
@Data
public class Department {
    private long id;

    private String name;

    private List<Department> children;

    public static void get(String args) {

    }
}

class Client{

    public static void get(String name,Department department) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < department.getChildren().size(); i++) {
            if(name.equals(department.getChildren().get(i).getName())){
                list.add(department.getChildren().get(i).getId());
            }
            for (Department child : department.getChildren()) {

            }
        }
    }

    public static void main(String[] args) {

    }
}
