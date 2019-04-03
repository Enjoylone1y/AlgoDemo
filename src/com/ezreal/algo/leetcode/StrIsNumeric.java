package com.ezreal.algo.leetcode;

public class StrIsNumeric {
    // 一个数值的表达式应该是[+|-]A[.B][e|E[+|-]C] 或者 [+|-].B[e|E[+|-]C],如
    // "+100","5e2","-123","3.1416"和"-1E-16" 都表示数值。
    // "12e","1a3.14","1.2.3","+-5"和"12e+4.3" 都不是。

    private int scanIndex = 0;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }

        // 首先查找前半部 [+|-]A
        boolean result = scanInteger(str);

        // 看是否指向了小数点，如果有，去除小数点，然后查找小数点后的数字
        if (scanIndex < str.length && str[scanIndex] == '.') {
            scanIndex++;
            // || scanUnsigned 是因为：
            // 小数点之前可以没有 [+|-]A，因为[+|-].B[e|E[+|-]C] 也是合法的
            // 但是小数点之后e之前只能是 Unsigned
            result = scanUnsigned(str) || result;
        }

        // 看是否指向了e
        if (scanIndex < str.length
                && (str[scanIndex] == 'e' || str[scanIndex] == 'E')) {
            scanIndex++;
            // && scanInteger 是因为：
            // 在e之前必须有数值，即 B[e|E[+|-]C] 否则不合法
            // 在e之后也必须有数值，但是可以是正值或者负值，即 [e|E[+|-]C] 都行
            result = scanInteger(str) && result;
        }

        // 最终，scanIndex 要走到末尾且符合上述条件
        return scanIndex == str.length && result;
    }

    private boolean scanInteger(char[] str) {
        if (scanIndex >= str.length){
            return false;
        }
        if (str[scanIndex] == '+' || str[scanIndex] == '-') {
            scanIndex++;
        }
        return scanUnsigned(str);
    }

    private boolean scanUnsigned(char[] str) {
        int sourceIndex = scanIndex;
        while (scanIndex < str.length && str[scanIndex] >= '0' && str[scanIndex] <= '9') {
            scanIndex++;
        }
        // 当 source 小于结果值时，表明存在若干的整数位
        return scanIndex > sourceIndex;
    }
}
