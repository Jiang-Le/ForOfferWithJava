import java.util.Arrays;

public class KthNodeFromEnd {
    public static ListNode findKthNodeFromEnd(ListNode head, int k) {
        if (k <= 0)
            return null;
            
        ListNode former = head;
        for (int i = 0; i < k; i++) {
            if (former == null)
                return null;
            former = former.next;
        }
        ListNode later = head;
        while (former != null) {
            later = later.next;
            former = former.next;
        }
        return later;
    }

    public static void test() {
        ListNode head = ListUtil.buildLinkedNode(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(findKthNodeFromEnd(head, 3));
        System.out.println(findKthNodeFromEnd(head, 1));
        System.out.println(findKthNodeFromEnd(head, 5));
        System.out.println(findKthNodeFromEnd(head, 10));
        System.out.println(findKthNodeFromEnd(head, -1));
    }

    public static void main(String[] args) {
        test();
    }
}