package com.ezreal.algo.leetcode;

import com.ezreal.algo.struct.ListNode;

public class DeleteDuplication {

    /**
     * 删除链表重复元素，对于重复元素，保留其中一个
     * 1->2->2->3->4  结果 1->2->3->4
     */
    public static ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode p = pHead;
        ListNode next;
        while (p.next != null) {
            next = p.next;
            // 不相等就继续递进，否则把p.next链接到再下一个节点继续循环即可
            if (next.val != p.val) {
                p = next;
            } else {
                p.next = next.next;
            }
        }
        return pHead;
    }

    /**
     * 删除链表重复元素，对于重复元素要全部删除
     * 1->2->2->3->4  结果 1->3->4
     */
    public static ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode p = pHead;
        ListNode pre = null;
        // 遍历链表
        while (p != null) {
            ListNode next = p.next;
            // 不是重复节点，继续往前
            if (next != null && next.val != p.val) {
                pre = p;
                p = next;
                continue;
            }
            // next为空则表明整个链表都已经不存在重复节点，直接结束
            if (next == null){
                break;
            }
            // 否则，找到所有和p相同节点，包括p本事都是要删除的
            ListNode delete = p;
            while (delete != null && p.val == delete.val) {
                delete = delete.next;
            }
            // 找完所有与p相等的节点，则从(pre,delete) 都是需要删除的元素
            // 所以要么把pre.next置为delete,要么把delete之前的都是删除，即把head移动到delete处
            if (pre != null){
                pre.next = delete;
            }else {
                pHead = delete;
            }
            // 当然，p也要重置到delete位置
            p = delete;
        }
        return pHead;
    }


}
