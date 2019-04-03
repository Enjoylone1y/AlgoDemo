package com.ezreal.algo.leetcode;

public class PrintMaxN {
    public void printMaxN(int n) {
        // 输入合法性判断
        if (n <= 0) {
            return;
        }
        // 使用数组存储数据
        int[] number = new int[n];
        // 进位后判断是否越界，不越界则打印
        while (!increase(number)) {
            printNumber(number);
        }
    }

    private boolean increase(int[] number) {
        boolean isOver = false;
        int iSum = 0;
        int preAdd = 0;
        for (int i = number.length - 1; i >= 0; i--) {
            // 个位数要加+1
            if (i == number.length - 1){
                number[i] = number[i] + 1;
            }
            // 对于每一个数，它当前的数要等于自己本事加上前一位数的和
            iSum = number[i] + preAdd;
            // 大于10就要进位了
            if (iSum >= 10){
                // 如果是最高位大于10，则证明已经越界了
                if (i == 0){
                    isOver = true;
                    break;
                }
                preAdd = 1;
                number[i] = 0;
            }else {
                // 当前位不大于10，那么对高位不会有任何影响，则不用计算高位数
                number[i] = iSum;
                break;
            }
        }
        return isOver;
    }


    private void printNumber(int[] number) {
        StringBuilder builder = new StringBuilder();
        // 从后往前拼接，从第一位不是0的数开始拼接
        boolean hasStart = false;
        for (int i = 0;i < number.length;i++){
            if (hasStart || number[i] > 0){
                hasStart = true;
                builder.append(number[i]);
            }
        }
        System.out.println(builder.toString());
    }

}
