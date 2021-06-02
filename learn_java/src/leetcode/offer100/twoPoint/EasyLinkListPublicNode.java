package leetcode.offer100.twoPoint;


import leetcode.offer100.base.ListNode;

public class EasyLinkListPublicNode {

    /**
     * 题目：剑指 Offer 52. 两个链表的第一个公共节点
     * 题目链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
     *
     * 解这种链表的题型首要想到的就是双指针
     * 我们设：
     * 链表A长度：x
     * 链表B长度：y
     * 我们用两个指针分别的遍历A和B
     * 指针1：先遍历A，在最后指向B的头节点，继续遍历
     * 指针2：先遍历B，在最后指向A的头节点，继续遍历
     *
     * 因为都遍历了两次，导致两个指针在公共节点的位置遍历的长度是一样的，因此两个指针相遇的位置就是公共点
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            // 这个地方不能使用pa.next == null做判断，因为有可能根本就没有共同点
            pa = pa == null ? headB: pa.next;
            pb = pb == null ? headA: pb.next;
        }
        return pa;
    }

    public static void main(String[] args) {

    }

}
