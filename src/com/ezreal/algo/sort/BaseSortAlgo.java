package com.ezreal.algo.sort;

/**
 * 基本排序算法
 * 1.冒泡、插入排序  时间：最好 O(n) 最坏O(n^2) 平均O(n^2), 空间 O(1) 稳定排序算法
 * 2.选择排序 时间：最好、最坏、平均 都是 O(n^2) 空间 O(1) 非稳定排序算法
 */
public class BaseSortAlgo {

    // 冒泡排序算法
    public static void bubbleSort(int[] src){
        if (src == null || src.length <= 1){
            return;
        }
        for (int i=0;i<src.length;i++){
            for (int j=0;j<src.length - i - 1;j++){
                if (src[j] > src[j+1]){
                    int temp = src[j+1];
                    src[j+1] = src[j];
                    src[j] = temp;
                }
            }
        }
    }

    // 插入排序算法
    public static void insetSort(int[] src){
        if (src == null || src.length <= 1){
            return;
        }
        for (int i=1;i<src.length;i++){
            int key = src[i];
            int index = i;
            for (int j=i-1;j>=0;j--){
                if (src[j] > key){
                    src[j+1] = src[j];
                    index = j;
                }else {
                    break;
                }
            }
            if (index != i){
                src[index] = key;
            }
        }
    }

    // 选择排序算法
    public static void selectSort(int[] src){
        if (src == null || src.length <= 1){
            return;
        }
        for (int i=0;i<src.length-1;i++){
            int min = src[i];
            int index = i;
            for (int j = i+1;j<src.length;j++){
                if (src[j] < min){
                    min = src[j];
                    index = j;
                }
            }
            if (index != i){
                int temp  = src[i];
                src[i] = src[index];
                src[index] = temp;
            }
        }
    }

}
