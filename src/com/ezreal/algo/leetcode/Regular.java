package com.ezreal.algo.leetcode;

import java.util.Arrays;

public class Regular {
    // 使用递归解决，每次匹配一位或者两位（正则里面第二位是*时）
    public static boolean match(char[] str, char[] pattern) {
        // 输入合法性判断
        if (pattern == null) return str == null;
        if (pattern.length == 0) return str.length == 0;

        // 当pattern只有一个字符的情况下，str只能有一个字符
        // 且要么pattern中的字符是.，要么只能和str中的字符相等
        if (pattern.length == 1) {
            return str.length == 1 && (pattern[0] == '.' || pattern[0] == str[0]);
        }
        // 当pattern有两个字符的情况下，分两种情况:

        // 如果pattern第二个字符不是*,则匹配第一个字符然后递归即可
        if (pattern[1] != '*') {
            // 如果此时str为空，或者pattern第一个字符不是.并且不等的时候，已经不匹配了
            if (str.length == 0 || (pattern[0] != '.' && pattern[0] != str[0])) {
                return false;
            }
            // 否则匹配第一个字符，去掉第一个字符后递归
            char[] strNext = Arrays.copyOfRange(str, 1, str.length);
            char[] patternNext = Arrays.copyOfRange(pattern, 1, pattern.length);
            return match(strNext, patternNext);
        }

        // 如果第二个字符是*的情况下,根据*的定义，循环匹配str中所有和pattern[0]相等的字符
        while (str.length != 0 && str[0] == pattern[0] || pattern[0] == '.') {
            // 循环过程中，每完成一位匹配，要判断去掉这一位已经匹配的之后是否可以匹配成功
            char[] patternNext = Arrays.copyOfRange(pattern, 2, pattern.length);
            if (match(str, patternNext)) return true;
            // 递归过程中，str每匹配一位就去掉一位
            str = Arrays.copyOfRange(str, 1, str.length);
        }

        // 已经把str中所有的pattern[0]字符都去掉了，则把pattern[0]以及pattern[1]的*去掉，继续递归
        char[] patternNext = Arrays.copyOfRange(pattern, 2, pattern.length);
        return match(str, patternNext);
    }
}
