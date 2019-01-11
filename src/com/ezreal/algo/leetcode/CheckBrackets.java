package com.ezreal.algo.leetcode;

import java.util.Stack;

/**
 * leetcode 20.
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class CheckBrackets {

    private static final char MIN_LEFT = '(';
    private static final char MID_LEFT = '[';
    private static final char BIG_LEFT = '{';

    private static final char MIN_RIGHT = ')';
    private static final char MID_RIGHT = ']';
    private static final char BIG_RIGHT = '}';

    public static   boolean isValid(String s) {
        if (s == null || "".equals(s)){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            switch (c){
                case MIN_LEFT:
                case MID_LEFT:
                case BIG_LEFT:
                    stack.push(c);
                    break;
                case MIN_RIGHT:
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek() == MIN_LEFT){
                        stack.pop();
                    }else {
                        stack.push(c);
                    }
                    break;
                case MID_RIGHT:
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek() == MID_LEFT){
                        stack.pop();
                    }else {
                        stack.push(c);
                    }
                    break;
                case BIG_RIGHT:
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek() == BIG_LEFT){
                        stack.pop();
                    }else {
                        stack.push(c);
                    }

                    break;
            }
        }
        return stack.isEmpty();
    }
}
