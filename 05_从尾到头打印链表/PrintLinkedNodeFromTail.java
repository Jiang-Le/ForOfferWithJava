import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintLinkedNodeFromTail {
    public static void print(ListNode root) {
        List<ListNode> nodes = new ArrayList<>();

        while (root != null) {
            nodes.add(root);
            root = root.next;
        }

        for(ListNode node : nodes) {
            System.out.println(node.val);
        }
    }

    private static ListNode buildLinkedNode(List<Integer> vals) {
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

    public static void test() {
        ListNode root = buildLinkedNode(Arrays.asList(1, 2, 3, 4));
        print(root);

        ListNode root1 = buildLinkedNode(Arrays.asList());
        print(root1);

        ListNode root2 = buildLinkedNode(Arrays.asList(1));
        print(root2);

        System.out.println("success");
    }

    public static void main(String[] args) {
        test();
    }
}