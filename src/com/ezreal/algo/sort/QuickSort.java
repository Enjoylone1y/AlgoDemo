package com.ezreal.algo.sort;

/**
 * 快速排序
 * 利用分治思想
 * 随机获取一个分区数（锚点），通过交换把数组分成左右两边，左边比锚点值小，右边比锚点值大
 * 而后再递归分别处理对上面步骤分出的左边和右边数组，直到所有数据有序
 * 时间： 最好 O(n) 最坏 O(n^2) 平均 O(N*logN)
 * 空间：原地排序算法，O(1)
 * 非稳定排序算法
 */
public class QuickSort {

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // 递归函数
    private static void quickSort(int[] array, int l, int r) {
        if (l >= r) return;
        // 分区，得到分区点索引
        int q = partition(array, l, r);
        // 递归左边
        quickSort(array, l, q - 1);
        // 递归右边
        quickSort(array, q + 1, r);
    }

    // 分区函数
    private static int partition(int[] array, int l, int r) {
        // 随机获取分区锚点
        int index = (int) (l + Math.random() * (r - l));
        int pivot = array[index];
        // 把锚点放到最后
        swap(array,index,r);
        // 开始分区，小于锚点值放『左边』，否则放右边
        int i = l;
        for (int j = l; j < r; ++j) {
            if (array[j] < pivot) {
                swap(array, i, j);
                ++i;
            }
        }
        // 最后把锚点放回中间位置
        swap(array, i, r);
        return i;
    }

    // 第二种写法
    private static int patition2(int[] array, int l, int r) {
        while (l < r) {
            while (array[r] >= array[l] && l < r) {
                r--;
            }
            swap(array, r, l);
            while (array[l] <= array[r] && l < r) {
                l++;
            }
            swap(array, r, l);
        }
        return l;
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
