package com.ezreal.algo.search;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 最基本的二分查找，在一个有序数组中找到k，返回其所在位置
     */
    public static int baseSearch(int[] arr,int k){
        int low = 0;
        int height = arr.length - 1;
        while (low <= height){
            int mid  = low + (height - low ) / 2;
            if(arr[mid] == k){
                return mid;
            }else if (arr[mid] > k){
                height = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变体1，找到第一个值为k的位置
     * 找到值之后，往前找
     */
    public static int findFirstK(int[] arr,int k){
        int low = 0;
        int height = arr.length - 1;
        while (low <= height){
            int mid = low + (height - low) / 2;
            if (arr[mid] > k){
                height = mid - 1;
            }else if (arr[mid] < k){
                low = mid + 1;
            }else {
                while (mid >= 0 && arr[mid-1] == k){
                    mid--;
                }
                return ++mid ;
            }
        }
        return -1;
    }

    /**
     * 变体2，找到第一个小于等于k的位置
     */
    public static int findFirstMinK(int[] arr,int k){
        int low = 0;
        int height = arr.length - 1;
        while (low <= height){
            int mid = low + (height - low) / 2;
            if (arr[mid] > k){
                height = mid - 1;
            }else {
                while (mid >= 0 && arr[mid] <= k){
                    mid--;
                }
                return ++mid;
            }
        }
        return -1;
    }

}
