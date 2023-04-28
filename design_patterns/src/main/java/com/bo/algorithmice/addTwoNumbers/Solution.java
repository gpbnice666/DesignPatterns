package com.bo.algorithmice.addTwoNumbers;


class ListNode {
    int val;
    ListNode next;

    ListNode () {
    }

    ListNode (int val) {
        this.val = val;
    }

    ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * https://leetcode.cn/problems/add-two-numbers/
 * 解题思路：
 * 1. 先找到最长的链表
 * 2. 遍历最长的链表,两个链表进行相加
 * 
 */
class Solution {
    public static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        int i1 = getListSize(l1);
        int i2 = getListSize(l2);
        int sum = 0;
        int sum1 = 0;
        int i = 0;
        ListNode node = new ListNode();
        if (i1 >= i2) {
            while (l1 != null) {
                int l2num = 0;
                if (l2 != null) {
                    l2num = l2.val;
                    l2 = l2.next;
                }
                int tatol = l1.val + l2num + sum;
                if (tatol >= 10) {
                    tatol = tatol % 10;
                    sum = 1;
                } else {
                    sum = 0;
                }
                if (i == 0) {
                    node.val = tatol;
                } else {
                    node = add(node, new ListNode(tatol));
                    sum1 = tatol;
                }
                l1 = l1.next;
                if(l1 == null && tatol == 0 && sum == 1){
                    node = add(node, new ListNode(1));
                }
                if(l1 == null && tatol != 0 && sum == 1){
                    node = add(node, new ListNode(1));
                }
                i++;
            }
        } else {
            while (l2 != null) {
                int l1num = 0;
                if (l1 != null) {
                    l1num = l1.val;
                    l1 = l1.next;
                }
                int tatol = l2.val + l1num + sum;

                if (tatol >= 10) {
                    tatol = tatol % 10;
                    sum = 1;
                } else {
                    sum = 0;
                }
                if (i == 0) {
                    node.val = tatol;
                } else {
                    node = add(node, new ListNode(tatol));
                    sum1 = tatol;
                }
                l2 = l2.next;

                if(l2 == null && tatol == 0 && sum == 1){
                    node = add(node, new ListNode(1));
                }
                i++;

            }
        }
        if(sum1 == 10){
            node = add(node, new ListNode(1));
        }
        return node;

    }

    public static ListNode add (ListNode node, ListNode add) {
        ListNode h = node;
        while (h.next != null) {
            h = h.next;
        }
        h.next = add;
        return node;
    }

    public static int getListSize (ListNode l) {
        int i = 0;
        ListNode node = l;
        while (node.next != null) {
            i++;
            node = node.next;
        }
        return i;
    }


    public static void main (String[] args) {
        // [2,4,3]
        //[5,6,4]
        //
//[9,9,9,9,9,9,9]
//[9,9,9,9]
//        ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));

//        ListNode node1 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))));
//        ListNode node2 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))));
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node = addTwoNumbers(node1, node2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

//        ListNode a1 = new ListNode(1);
//        ListNode a2 = new ListNode(2);
//        ListNode a3 = new ListNode(3);
//        ListNode a4 = new ListNode(4);
//
//        a1.next = a2.next = a3.next = a4;
//
//        while (a1 != null) {
//            System.out.println(a1.val);
//            a1 = a1.next;
//        }
    }
}