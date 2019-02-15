package com.ezreal.algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeUtils {

    /**
     * 前序遍历,先自己，再左，后右
     */
    public static void preOrderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode p = root;

        //循环，当前节点为空且栈为空时结束
        while (p != null || !nodeStack.isEmpty()) {
            // 当前节点不为空时，打印自己,然后进入左边
            if (p != null) {
                result.add(p.val);
                nodeStack.push(p);
                p = p.left;
            }
            // 出栈，进入右边
            else {
                p = nodeStack.pop();
                p = p.right;
            }
        }

        System.out.println(result.toString());
    }

    /**
     * 中序遍历，先左，到自己，再右
     */
    public static void inOrderTraversal(TreeNode root) {

        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode p = root;

        // 循环，当前节点为空且栈为空时结束
        while (p != null || !nodeStack.isEmpty()) {
            // 当前节点不为空时，将自己保存起来，并进入左节点,即 先左
            if (p != null) {
                nodeStack.push(p);
                p = p.left;
            }
            // 否则栈顶出栈，打印自己，并进入右边节点
            else {
                p = nodeStack.pop();
                result.add(p.val);
                p = p.right;
            }
        }

        System.out.println(result.toString());
    }

    /**
     * 后续遍历,先左，再右，后自己。所以对于非叶子节点要入栈两次
     */
    public static void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode p = root;
        TreeNode prePrint = null;

        // 循环，当前节点为空且栈为空时结束
        while (p != null || !nodeStack.isEmpty()) {
            // 当前节点不为空时，将自己保存起来并进入左节点
            if (p != null) {
                nodeStack.push(p);
                p = p.left;
            }
            // 当前节点为空,栈不为空
            else {
                // 取栈顶数据
                p = nodeStack.pop();
                // 当前节点的右节点为空或者刚刚已经被访问过了，那就到他自己了
                if (p.right == null || p.right == prePrint){
                    result.add(p.val);
                    prePrint = p;

                    // 到这一步证明左右以及自己都被访问过了，要置空触发下一次出栈
                    p = null;
                }
                // 否则，刚刚访问到的是左节点，根节点要再入栈，先去访问右节点
                else {
                    nodeStack.add(p);
                    p = p.right;
                }
            }
        }

        System.out.println(result.toString());
    }
}
