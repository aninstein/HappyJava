package leetcode.offer100.lctwoPoint;


import base.ListNode;

public class EasyKthFromEnd {
    /**
     * 题目：剑指 Offer 22. 链表中倒数第k个节点
     * 题目链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
     *
     * 使用双指针，前指针先往后跳k步，这时候前后指针就相隔了k步，这只猴前后指针只需要正常向前移动，前指针移动到链表尾部，后指针即前k个
     * @param head 头节点
     * @param k 前k
     * @return 倒数第k个
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode first = head, last = head;
        int firstCount = 1;  // 具体第k个应该是从1开始
        while (first.next != null) {
            if (firstCount < k) {
                first = first.next;
                firstCount++;
                continue;
            }
            first = first.next;
            last = last.next;
        }
        return last;
    }

    public static void main(String[] args) {

    }

}
