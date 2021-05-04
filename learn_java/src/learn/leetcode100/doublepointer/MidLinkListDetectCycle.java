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

    /**
     * 使用快慢指针，fast指针每次走两步，slow指针每次走一步，这样如果链表有环，则fast和slow指针一定会相遇，否则fast指针能直接走完链表。
     *
     * 我们记录入环点记为A点，fast与slow指针相遇的点位B点
     * 我们设表头到入环点的位置长度为：x
     * 设在fast与slow相遇之前，fast指针已经在环内转到了第n圈，这第n+1圈没有转完就遇到了slow，记录入环点A到相遇点B的距离为：y
     * 而环内剩余的长度则为：z
     * 即环的长度为：C = y+z
     * 因此fast指针在相遇点前走过的路程为：x + n(y + z) + y
     * 而slow指针相遇点前走过的路程为：2(x + y)
     *
     * 又有，不管什么时候，fast指针走过的长度总为slow指针的一倍：
     * 即：
     * 2(x + y) = x + n(y + z) + y
     * 2x + 2y = x + (n + 1)y + nz
     * x = (n - 1)y + nz
     * x = (n - 1)y + (n - 1)z + z
     * x = (n - 1)(y + z) + z
     *
     * 我们看到其中的(y + z)实际上就是环长C，因此前面的n-1不管转多少圈，在从链表头部走完x的时候，都会在相遇点B多走出z的位置，也就是入环点A
     *
     *
     * @param head
     * @return
     */
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
