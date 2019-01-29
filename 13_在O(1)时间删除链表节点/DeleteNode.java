import java.util.Arrays;

public class DeleteNode {

    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null)
            return head;

        if (toBeDeleted.next != null) {
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        } else if (toBeDeleted.next == null) {
            if (toBeDeleted == head) {
                return null;
            } else {
                ListNode pre = head;
                while (pre.next != toBeDeleted) 
                    pre = pre.next;
                pre.next = null;
            }
        }
        return head;
    }

    public static void test() {
        ListNode head = ListUtil.buildLinkedNode(Arrays.asList(1, 2, 3, 4));
        head = deleteNode(head, head.next.next);
        ListUtil.printLinkedNode(head);
        head = deleteNode(head, head.next.next);
        ListUtil.printLinkedNode(head);
        head = deleteNode(head, head);
        ListUtil.printLinkedNode(head);
        head = deleteNode(head, head);
        ListUtil.printLinkedNode(head);
        head = deleteNode(head, head);
        ListUtil.printLinkedNode(head);
    }

    public static void main(String[] args) {
        test();
    }
}