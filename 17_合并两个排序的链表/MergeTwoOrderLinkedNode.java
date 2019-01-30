import java.util.Arrays;

public class MergeTwoOrderLinkedNode {
    public static ListNode mergeTwoOrderedLinkedNode(ListNode head1, ListNode head2) {
        if (head2 == null)
            return head1;
        
        if (head1 == null)
            return head2;
        
        ListNode ret = null;
        ListNode lastNode = null;

        ListNode temp = null;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp = head1;
                head1 = head1.next;
            } else {
                temp = head2;
                head2 = head2.next;
            }

            if (ret != null) {
                lastNode.next = temp;
                lastNode = temp;
            } else {
                ret = temp;
                lastNode = temp;
            }
        }

        while (head1 != null) {
            lastNode = new ListNode(head1.val);
            head1 = head1.next;
            lastNode = lastNode.next;
        }

        while (head2 != null) {
            lastNode = new ListNode(head2.val);
            head2 = head2.next;
            lastNode = lastNode.next;
        }

        return ret;
    }

    public static void test() {
        ListNode head1 = ListUtil.buildLinkedNode(Arrays.asList(1, 3, 5, 7, 9));
        ListNode head2 = ListUtil.buildLinkedNode(Arrays.asList(2, 4, 6, 8, 10));
        ListNode newHead1 = mergeTwoOrderedLinkedNode(head1, head2);
        ListUtil.printLinkedNode(newHead1);

        ListNode head3 = ListUtil.buildLinkedNode(Arrays.asList(1, 3, 3, 7, 9));
        ListNode head4 = ListUtil.buildLinkedNode(Arrays.asList(2, 3, 5, 7, 10));
        ListNode newHead2 = mergeTwoOrderedLinkedNode(head3, head4);
        ListUtil.printLinkedNode(newHead2);

        ListNode head5 = ListUtil.buildLinkedNode(Arrays.asList());
        ListNode head6 = ListUtil.buildLinkedNode(Arrays.asList(2, 3, 5, 7, 10));
        ListNode newHead3 = mergeTwoOrderedLinkedNode(head5, head6);
        ListUtil.printLinkedNode(newHead3);

    }

    public static void main(String[] args) {
        test();
    }
}