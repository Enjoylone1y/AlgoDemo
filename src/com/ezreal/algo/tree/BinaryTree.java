package com.ezreal.algo.tree;

import java.util.*;

/**
 * 二叉树
 */
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
        TreeUtils.preOrderTraversal(root);
    }

    /**
     * 中序遍历，先左，到自己，再右
     */
    public void inOrderTraversal() {
        TreeUtils.inOrderTraversal(root);
    }

    /**
     * 后续遍历,先左，再右，后自己。所以对于非叶子节点要入栈两次
     */
    public void postOrderTraversal() {
        TreeUtils.postOrderTraversal(root);
    }
}
