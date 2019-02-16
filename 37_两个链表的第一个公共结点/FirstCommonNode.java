import java.util.Arrays;

public class FirstCommonNode {
    public static ListNode getFirstCommonNode(ListNode head1, ListNode head2) {
        
        if (head1 == null || head2 == null) 
            return null;

        int len1 = getLength(head1);
        int len2 = getLength(head2);

        ListNode former = null;
        ListNode later = null;
        int offset = 0;
        if (len1 >= len2) {
            former = head1;
            later = head2;
            offset = len1 - len2;
        } else {
            former = head2;
            later = head1;
            offset = len2 - len1;
        }

        for (int i = 0; i < offset; i++) {
            former = former.next;
        }

        while (former != null) {
            if (former == later)
                return former;
            former = former.next;
            later = later.next;
        }

        return null;
    }

    private static int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ret++;
            head = head.next;
        }

        return ret;
    } 

    public static void test() {
        ListNode head1 = ListUtil.buildLinkedNode(Arrays.asList(1, 2, 3, 4, 5));
        ListNode head2 = ListUtil.buildLinkedNode(Arrays.asList(5));
        head2.next = head1.next.next;

        System.out.println(getFirstCommonNode(head1, head2).val);
    }

    public static void main(String[] args) {
        test();
    }
}