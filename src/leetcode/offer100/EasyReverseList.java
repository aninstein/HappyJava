package leetcode.offer100;


import leetcode.offer100.base.ListNode;

import java.util.Stack;

public class EasyReverseList {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nowNode = head;
        ListNode preNode = null;
        while (nowNode != null) {
            ListNode tmp = nowNode.next;
            nowNode.next = preNode;
            preNode = nowNode;
            nowNode = tmp;
        }
        return preNode;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = ListNode.getLinkByArray(data);

    }

}
