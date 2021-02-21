package learn.leetcode100.doublepointer;

import leetcode.offer100.base.ListNode;

import java.util.HashSet;
import java.util.Set;


public class MidLinkListDetectCycle {
    /**
     * 题目：142. 环形链表 II
     * 题目链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/
     *
     * 这道题目有两种解法：
     * 1. 快慢指针
     * 2. set记录每一个节点，每次都判断是否当前节点前面已经出现过
     *
     *
     * @param head
     * @return
     */
    public static ListNode detectCycleMap(ListNode head) {
        // Map解法
        Set<String> linkSet = new HashSet<>();
        while (head != null) {
            String key = Integer.toHexString(head.hashCode());
            if (linkSet.contains(key)) {
                return head;
            }
            linkSet.add(key);
            head = head.next;
        }
        return null;
    }

    public static ListNode detectCycleFastSlowPoint(ListNode head) {
        // 快慢指针
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
