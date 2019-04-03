package com.ezreal.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LCommPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 2) {
            return "";
        }

        // 默认第一个字符串就是最长公共前缀
        List<Character> list = new ArrayList<>(strs[0].length());
        for (int i = 0; i < strs[0].length(); i++) {
            list.add(strs[0].charAt(i));
        }

        // 从第2个字符串开始，通过比对调整最长公共前缀
        for (int j = 2; j < strs.length; j++) {
            // 如果当前公共子串已经为空,或者当前字符为空，就直接返回了
            if (list.isEmpty() || strs[j].equals("")) {
                return "";
            }
            // 如果字符串长度都比公共前缀短，那就先缩短最长公共子串
            if (strs[j].length() < list.size()){
                list = list.subList(0,strs[j].length());
            }
            // 对于第j个字符串，从第一个字符开始和目前的公共子串比较
            for (int k = 0; k < strs[j].length() && k < list.size(); k++) {
                if (strs[j].charAt(k) == list.get(k)) {
                    continue;
                }
                // 出现不同字符，更新公共前缀数据
                list = list.subList(0, k);
            }
        }
        // 最终结果
        char[] chars = new char[list.size()];
        int i = 0;
        for (Character c : list) {
            chars[i] = c;
            i++;
        }
        return new String(chars);
    }
}
