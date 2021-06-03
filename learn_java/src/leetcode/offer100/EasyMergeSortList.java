package leetcode.offer100;

import base.ListNode;

public class EasyMergeSortList {

    /**
     * 题目：合并两个排序的链表
     * 题目链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
     *
     * 一般这个用双指针
     * 可以理解为把一个链表插入到另外一个链表中，这种做法更好的是能够把短的链表插入到长的链表当中
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode master = new ListNode(0);
        ListNode cur = master;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 ==null ? l2: l1;
        return master.next;
    }

    public static void main(String[] args) {
        int[] data1 = {1, 2, 4};
        int[] data2 = {1, 3, 4};
        ListNode l1 = ListNode.getLinkByArray(data1);
        ListNode l2 = ListNode.getLinkByArray(data2);
        ListNode head = mergeTwoLists(l1, l2);
        ListNode.printLinkList(head);
    }

}
