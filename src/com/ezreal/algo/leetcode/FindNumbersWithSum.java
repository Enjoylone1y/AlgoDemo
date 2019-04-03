package com.ezreal.algo.leetcode;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>(2);
        if (array == null || array.length < 2) {
            return result;
        }
        int minMulti = Integer.MAX_VALUE;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int s = array[left] + array[right];
            if (s == sum) {
                int multi = array[left] * array[right];
                if (multi < minMulti) {
                    minMulti = multi;
                    result.clear();
                    result.add(array[left]);
                    result.add(array[right]);
                    left++;
                    right--;
                }
            } else if (s < sum) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
