package com.ezreal.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉查找树
 */
public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree(int[] value){
        createTree(value);
    }

    private void createTree(int[] values){
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


    public TreeNode find(int value){
        TreeNode p = root;
        while (p != null){
            if (p.val == value){
                return p;
            }else if (value > p.val){
                p = p.left;
            }else {
                p = p.right;
            }
        }
        return null;
    }

    public void insert(int value){
        if (root == null){
            root = new TreeNode(value);
            return;
        }
        TreeNode p = root;
        while (true){
            if (value < p.val){
                if (p.left == null){
                    p.left = new TreeNode(value);
                    return;
                }
                p = p.left;
            }else {
                if (p.right == null){
                    p.right = new TreeNode(value);
                    return;
                }
                p = p.right;
            }
        }
    }


    // 删除操作分三种情况：
    // 1. 叶子节点，直接删除即可
    // 2. 只有左边节点或者右边节点，让其父节点指向其子节点，后删除即可
    // 3. 有左右节点，需要找到其"前驱"或者"后继"节点来替换它的位置
    // 所谓前驱即小于它的最大值，即其左节点的右节点的右节点……直到最右节点
    // 所谓后继即大于它的最小值，即其右节点的左节点的左节点……直到最坐节点

    public boolean delete(int target){
        // 待删除节点p，默认先指向根节点
        TreeNode p = root;
        // 待删除节点的父节点
        TreeNode pp = null;
        // 先找到p的所在
        while (p != null && p.val != target){
            pp = p;
            if (target < p.val){
                p = p.left;
            }else {
                p = p.right;
            }
        }
        // 没有找到
        if (p == null){
            return false;
        }

        // 先处理第三种情况
        // 因为第三种情况处理完成后，待删除节点就最多只有一个子节点了，就可以按照1、2来统一处理
        // 在此采用找其后继节点的方式
        if (p.left != null && p.right != null){
            TreeNode after = p.right;
            TreeNode afterP = p;
            while (after.left != null){
                afterP = after;
                after = after.left;
            }
            // 将数据拷贝到P中
            p.val = after.val;
            // 然后after节点就变成要被删除的节点了
            p = after;
            pp = afterP;
        }

        // 至多有一个子节点的情况,先找子节点
        TreeNode child;
        if (p.left != null){
            child = p.left;
        }else if (p.right != null){
            child = p.right;
        }else {
            child = null;
        }

        // pp==null即删除的是根节点
        if (pp == null){
            root = child;
        }
        // 否则判断连接到左边或者右边
        else if (pp.left == p){
            pp.left = child;
        }else {
            pp.right = child;
        }
        return true;
    }


}
