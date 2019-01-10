package com.ezreal.algo.sort;

/**
 * 希尔排序
 * 改进版插入排序，使用分治思想，从大跨度（增量）排序到小跨度（增量）排序，希尔排序也叫 缩小增量排序
 * 通过『宏观调控』先让一部分数据有序，最终达到全部有序
 * 平均时间复杂度 O(N * LogN)
 * 控件复杂度 O(1) ， 非稳定排序算法
 */
public class ShellSort {
    public static void sort(int[] src){
        if (src == null || src.length <= 1){
            return;
        }
        int gap = src.length / 2 ;
        while (gap > 0){
            for (int i=gap;i<src.length;i++){
                int key = src[i];
                int index = i;
                for (int j=i-gap;j>=0;j-=gap){
                    if (src[j] > key){
                        src[j+gap] = src[j];
                        index = j;
                    }else {
                        break;
                    }
                }
                if (index != i){
                    src[index] = key;
                }
            }
            gap /= 2;
        }
    }
}
