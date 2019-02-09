public class CloneComplexLinkedList {
    public static ComplexListNode clone(ComplexListNode head) {
        if (head == null)
            return null;
        ComplexListNode ret = dublicate(head);
        ret = cloneSibling(ret);
        return seperate(ret);
    }

    private static ComplexListNode dublicate(ComplexListNode head) {
        ComplexListNode p = head;

        ComplexListNode newNode = null;
        ComplexListNode temp = null;
        while (p != null) {
            newNode = new ComplexListNode(p.value);
            temp = p.next;
            p.next = newNode;
            newNode.next = temp;
            p = temp;
        }
        return head;
    }

    private static ComplexListNode cloneSibling(ComplexListNode head) {
        ComplexListNode p = head;

        while (p != null) {
            if (p.sibling != null)
                p.next.sibling = p.sibling.next;
            p = p.next.next;
        }
        return head;
    }

    private static ComplexListNode seperate(ComplexListNode head) {
        ComplexListNode p = head;
        ComplexListNode ret = head.next;

        ComplexListNode temp = null;

        while (p != null) {
            temp = p.next;
            p.next = p.next.next;
            if (p.next != null)
                temp.next = p.next.next;
            else
                temp.next = null;
            p = p.next;
        }

        return ret;
    }

    public static void test() {
        // TODO: test this solution
    }

    public static void main(String[] args) {
        test();
    }

}