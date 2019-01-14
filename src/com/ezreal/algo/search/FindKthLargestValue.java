package com.ezreal.algo.search;


/**
 * 在O(n) 时间内，找到数组中第 k 大的元素
 * 利用快排的分区思想，选择一个锚点，将数据进行分区，小于锚点的放左边，大于的放右边，返回锚点的位置 p
 * 此时，p = k，则arr[p] 就是第k大元素
 * 如果p > k,则第k大元素在左边区域，否则在右边区域，使用递归很容易实现
 */
public class FindKthLargestValue {

    public static int findValue(int[] array,int topIndex){
        return find(array,0,array.length - 1,topIndex - 1);
    }

    private static int find(int[] array,int left,int right,int topIndex){


        int partition = partition(array, left, right);
        if (partition == topIndex){
            return array[partition];
        }else if (partition > topIndex){
            return find(array,left,partition - 1,topIndex);
        }else {
            return find(array,partition+1,right,topIndex);
        }
    }

    private static int partition(int[] array,int left,int right){
        int value = array[right];
        int i = left;
        for (int j = left;j<right;j++){
            if (array[j] > value){
                swap(array,i,j);
                i++;
            }
        }
        swap(array,right,i);
        return i;
    }

    private static void swap(int[] array,int i,int j){
        int temp  = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
