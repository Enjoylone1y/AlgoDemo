package com.ezreal.algo.leetcode;

public class Pow {
    public static double Power(double base, int exponent) {
        // 输入合法性和特殊性
        if(base == 0) return 0;
        if(exponent == 0) return 1;
        // 如果是负次幂则记录并先取正次幂计算。
        boolean re = false;
        if(exponent < 0){
            exponent = - exponent;
            re = true;
        }
        double result = pow(base,exponent);
        // 负次幂则取结果分之一，否则计算结果即可
        return re ? 1.0/result : result;
    }
    // n为偶数，a^n = a^n/2 * a^n/2，奇数 a^n = a * a^ (n-1)/2 * a^ (n-1)/2
    private static double pow(double base,int exp){
        if(exp == 0) return 1.0;
        if(exp == 1) return base;
        double result = pow(base,exp >> 1);
        result *= result;
        // 且每次除以二都是取整数的，每次取半的时候，如果是奇数次还要多乘一次
        return exp % 2 == 0 ? result : base * result;
    }
}
