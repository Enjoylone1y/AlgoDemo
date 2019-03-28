package com.ezreal.algo;

//import com.ezreal.algo.sort.QuickSort;

import com.ezreal.algo.leetcode.LCommPrefix;
import com.ezreal.algo.search.BinarySearch;
import com.ezreal.algo.search.FindKthLargestValue;
import com.ezreal.algo.search.RobotMoveCount;
import com.ezreal.algo.search.StrInMatrix;
import com.ezreal.algo.tree.BinaryTree;
import sun.jvm.hotspot.utilities.BitMap;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.*;
import java.util.*;

public class Main {

    private static final int size = 1000;

    public static void main(String[] args) {
        // 排序测试
//        int[] array = getRangeArray();
//        System.out.println("src:");
//        printArray(array);
//
//        long startTime = System.currentTimeMillis();

//        BaseSortAlgo.insetSort(array);
//        ShellSort.sort(array);
//        MergeSort.sort(array);
//        QuickSort.sort(array);
//
//
//        System.out.println("after sort:");
//        printArray(array);
//
//        long useTime = System.currentTimeMillis() - startTime;
//        System.out.println("useTime = " + useTime);
//        System.out.println();
//
//        // 链表测试
//        SingleLinkList<String> linkList = new SingleLinkList<>();
//        // 插入尾部
//        linkList.add("3");
//        linkList.add("4");
//        // 插入头部
//        linkList.add(0,"1");
//        // 插入中间
//        linkList.add(1,"2");
//        // 再差尾部
//        linkList.add("5");
//        // 测试列表反转
//        linkList.reverse();
//        linkList.reverse();
//
//        // 打印
//        linkList.printAll();
//
//        System.out.println(String.format("0 = %s , 3 = %s",linkList.get(0),linkList.get(3)));
//
//        linkList.remove(0);
//        linkList.remove("4");
//        linkList.remove(2);
//        linkList.remove(1);
//        linkList.printAll();
//        linkList.add("3");
//        linkList.add("4");
//        linkList.add("5");
//        linkList.printAll();
//        linkList.clear();
//        linkList.printAll();

        // 搜索算法，华容道试题测试

//        int[][] src = new int[][]{{3,4,1},{5,6,0},{8,2,7}};
//        DeepSearch huaRongDao = new DeepSearch(src);
//        System.out.println("src = ");
//        huaRongDao.print();
//        System.out.println();
//        boolean solve = huaRongDao.solve();
//        if (solve){
//            System.out.println("success step = " + huaRongDao.getStep() + "\n");
//            huaRongDao.printRoute();
//            System.out.println("\n\n");
//            System.out.println("result=");
//            huaRongDao.print();
//        }else {
//            System.out.println("can't solve");
//        }

          // 队列，FIFO，不越界的情况下都是 1234567出来
//        LinkQueue<Integer> queue = new LinkQueue<>();
//
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        queue.push(4);
//
//        System.out.println(queue.pop());
//
//        queue.push(5);
//
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//
//        queue.push(6);
//        queue.push(7);
//
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());

//          // 1234入，然后出栈，再入5，再出栈，再入67，然后依次出栈，结果应该是 4576321
//        LinkStack<Integer> stack = new LinkStack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//
//        System.out.println(stack.pop());
//
//        stack.push(5);
//
//        System.out.println(stack.pop());
//
//        stack.push(6);
//        stack.push(7);
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

//        System.out.println("() =  " +CheckBrackets.isValid("()"));
//        System.out.println("()[]{} =  " +CheckBrackets.isValid("()[]{}"));
//        System.out.println("([)] =  " +CheckBrackets.isValid("([)]"));
//        System.out.println("{[]} =  " +CheckBrackets.isValid("{[]}"));

//        int value = FindKthLargestValue.findValue(new int[]{3,2,1,5,6,4}, 2);
//        System.out.println(value);

//
//        int[] ints = BinarySearch.searchRange(new int[]{-1, 2, 3, 4, 6, 7, 8, 8, 8, 12, 34, 54}, 8);
//        System.out.println("s = " + ints[0] + ",e = " + ints[1]);

//        BinaryTree binaryTree = new BinaryTree(new int[]{1,2,3,-1,4,5});
//        binaryTree.preOrderTraversal();
//        binaryTree.inOrderTraversal();
//        binaryTree.postOrderTraversal();
//        LinkedHashMap<Integer,Integer> hashMap = new LinkedHashMap<>();
//        Integer key = hashMap.keySet().iterator().next();
//        hashMap.remove(key,hashMap.get(key));
//
//        String prefix = LCommPrefix.longestCommonPrefix(new String[]{"flower","floght","fl"});
//        System.out.println(prefix);
//
//        double pow = Math.pow(2, 5);

//        boolean hasPath = StrInMatrix.hasPath(new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'},
//                3, 4, "bcced".toCharArray());
//        System.out.println(hasPath);

        int count = RobotMoveCount.movingCount(5, 10, 10);
        System.out.println(count);


    }


    public String replaceSpace(StringBuffer str) {
        if(str == null){
            return null;
        }
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) == ' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();


    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>(stack.size());
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    private static int[] getRangeArray(){
        long currentTimeMillis = System.currentTimeMillis();
        int[] result = new int[size];
        Random random = new Random(currentTimeMillis);
        for (int i =0 ;i<size;i++){
            result[i] = random.nextInt(size);
        }
        return result;
    }

    // 打印前150个
    private static void printArray(int[] array){
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<array.length && i < 150;i++) {
            builder.append(array[i]).append(",");
        }
        System.out.println(builder.toString());
        System.out.println();
    }

}
