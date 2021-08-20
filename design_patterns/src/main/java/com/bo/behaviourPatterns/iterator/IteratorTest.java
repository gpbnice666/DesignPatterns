package com.bo.behaviourPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gpb
 *
 */
public class IteratorTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(143);
        list.add(134);
        list.add(54);
        list.add(435);
        System.out.println(list.size());
        System.out.println(list.get(list.size()));

    }

}
