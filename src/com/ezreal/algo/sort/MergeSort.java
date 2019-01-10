package com.ezreal.algo.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 利用分治思想排序，分段排序后再将分段合并 ，时间：最好，最好，平均都是 O(N*logN)
 * 非原地排序，合并的时候需要申请额外数组空间 ，空间 O(N)
 * 稳定排序算法
 */
public class MergeSort {

    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        // 开始，申请一个与原数组一样大的空间，避免排序过程中重复申请和释放空间
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
    }

    // 递归函数
    private static void sort(int[] array, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        // 计算终点
        int mind = (left + right) / 2;
        // 递归对左边进行排序
        sort(array, left, mind, temp);
        // 递归对右边进行排序
        sort(array, mind + 1, right, temp);
        // 对排好序的部分进行合并
        merge(array, left, mind, right, temp);
    }

    // 合并函数
    private static void merge(int[] array, int left, int mind, int right, int[] temp) {
        int i = left; // 左边起点
        int j = mind + 1; // 右边起点
        int k = left; // temp 数组起点

        // 两边数据按排序顺序合并
        while (i <= mind && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mind) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        // 合并好的数组赋值回原始数组
        while (left <= right) {
            array[left] = temp[left];
            left++;
        }
    }


    // 第二种写法

    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }


    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
}
