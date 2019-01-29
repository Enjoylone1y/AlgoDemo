package com.ezreal.algo.tree;

import java.util.*;

public class BinaryTree {

    private TreeNode root;

    /**
     * 用数组初始化二叉树，-1 代表节点为空
     */
    public BinaryTree(int[] values) {
        createTree(values);
    }

    // 使用队列创建二叉树
    private void createTree(int[] values) {
        // 先创建根节点
        root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode p;
        int i = 1;
        while (!queue.isEmpty()) {
            // 已经遍历完所有节点，退出循环
            if (i == values.length) {
                break;
            }
            // 取出父节点
            p = queue.remove();

            // 放左边节点
            if (values[i] != -1) {
                TreeNode left = new TreeNode(values[i]);
                p.left = left;
                queue.add(left);
            }
            i++;

            if (i == values.length) {
                break;
            }

            // 放右边节点
            if (values[i] != -1) {
                TreeNode right = new TreeNode(values[i]);
                p.right = right;
                queue.add(right);
            }

            i++;
        }
    }

    /**
     * 前序遍历,先自己，再左，后右
     */
    public void preOrderTraversal() {
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
    public void inOrderTraversal() {

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
    public void postOrderTraversal() {
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
