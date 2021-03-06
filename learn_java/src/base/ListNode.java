package base;


// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode getLinkByArray(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        ListNode head = new ListNode(data[0]);;
        for (int i = 1; i < data.length; i++) {
            head.next = new ListNode(data[i]);
            head = head.next;
        }
        return head;
    }

    public static void printLinkList(ListNode head) {
        ListNode now = head;
        while (now != null) {
            System.out.print(" " + now.val);
            now = now.next;
        }
        System.out.println();
    }

}
