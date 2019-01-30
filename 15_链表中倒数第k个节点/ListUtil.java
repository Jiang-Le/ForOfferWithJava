import java.util.List;

public class ListUtil {
    public static ListNode buildLinkedNode(List<Integer> vals) {
        ListNode root = null, p = null;
        for (int val : vals) {
            if (p == null){
                p = new ListNode(val);
                root = p;
            } else {
                p.next = new ListNode(val);
                p = p.next;
            }
        }
        return root;
    }

    public static void printLinkedNode(ListNode head) {
        while (head != null) {
            System.out.print(String.format("%d->", head.val));
            head = head.next;
        }
        System.out.println("null");
    }
}