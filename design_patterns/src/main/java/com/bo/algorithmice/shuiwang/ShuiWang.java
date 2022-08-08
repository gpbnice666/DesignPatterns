package com.bo.algorithmice.shuiwang;

/**
 * @author gpb
 * @date 2022/8/7 21:59
 */
public class ShuiWang {


    /**
     * 思路就是：
     *      两个相同的数 就删除
     * @param arr
     * @return
     */
   public static int getNum(int arr[]){

       if(arr==null || arr.length<=0)
           return -1;
       // 候选数据进行比较
       int a = 0;
       // 候选数据的血量 状态 如果下一个数 和 候选数据 相等 血量加1  不相等 -1
       int b = 0;

       for (int i : arr) {
           if(b == 0){
               a=i;
               b++;
           }else if(a == i){
               b ++ ;
           }else {
               b --;
           }
       }
       if(b == 0){
           return -1;
       }
       b = 0;
       for (int i : arr) {
           if(i == a){
               b ++;
           }
       }
       return  b> arr.length/2 ? a : -1;
   }


    public static void main(String[] args) {
        System.out.println(getNum(new int[]{1,3,1,3,3,1,77,3,3}));
    }

}
