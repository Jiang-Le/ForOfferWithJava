import java.util.Arrays;

public class ReverseListNode {
    public static ListNode reverseLinkedNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode ret = null;
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next = ret;
            ret = head;
            head = temp;
        }
        return ret;
    }

    public static void test() {
        ListNode head1 = ListUtil.buildLinkedNode(Arrays.asList(1, 2, 3, 4, 5));
        head1 = reverseLinkedNode(head1);
        ListUtil.printLinkedNode(head1);

        ListNode head2 = ListUtil.buildLinkedNode(Arrays.asList(1));
        head2 = reverseLinkedNode(head2);
        ListUtil.printLinkedNode(head2);

        ListNode head3 = ListUtil.buildLinkedNode(Arrays.asList());
        head3 = reverseLinkedNode(head3);
        ListUtil.printLinkedNode(head3);
    }

    public static void main(String[] args) {
        test();
    }
}