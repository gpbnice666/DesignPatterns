package com.bo.algorithmice.twoSum;


import java.util.HashMap;

/**
 * 两数之和
 * nums = [2,7,11,15], target = 9
 * 9 - 2 = 7
 *
 */
public class TwoSum {


    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1 ; j < nums.length; j++) {
                if(target - nums[i] == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public static int[] hashTwoSum(int[] nums, int target) {
        //       数据       数据所在的下表
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            //    7   =   9    -  2;
            //    2   =   9    -  7;
            if(hashMap.containsKey(temp)){
                return new int[]{i,hashMap.get(temp)};
            }
            hashMap.put(nums[i],i);
            //            2,0
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15,54};
        int target = 65;
        int[] ints = hashTwoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}