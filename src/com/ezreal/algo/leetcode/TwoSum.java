package com.ezreal.algo.leetcode;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int y;
        for (int i = 0 ;i<nums.length;i++){
             y = target - nums[i];
             if (map.containsKey(y)){
                 return new int[]{i,map.get(y)};
             }
             map.put(nums[i],i);
        }
        return null;
    }
}
