import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ConvertBinarySearchTree {
    public static BinaryTreeNode convert(BinaryTreeNode root) {
        return midOrder(root, null);
    }

    private static BinaryTreeNode midOrder(BinaryTreeNode root, BinaryTreeNode last) {
        List<BinaryTreeNode> stack = new ArrayList<>();
        BinaryTreeNode head = null;

        BinaryTreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                push(stack, current);
                current = current.left;
            } else {
                current = pop(stack);
                
                if (last != null) {
                    last.right = current;
                    current.left = last;
                } else {
                    head = current;
                }
                last = current;

                current = current.right;
            }
        }

        return head;

    }

    private static void push(List<BinaryTreeNode> stack, BinaryTreeNode element) {
        stack.add(element);
    }

    private static BinaryTreeNode pop(List<BinaryTreeNode> stack) {
        return stack.remove(stack.size() - 1);
    }

    private static void print(BinaryTreeNode head) {
        BinaryTreeNode tail = null;
        while (head != null) {
            System.out.print(
                String.format(
                    "%d->",
                    head.value
                )
            );
            if (head.right == null) {
                tail = head;
                System.out.println("null");
            }
            head = head.right;
        }

        while (tail != null) {
            System.out.print(
                String.format(
                    "%d->",
                    tail.value
                )
            );
            if (tail.left == null) {
                System.out.println("null");
            }
            tail = tail.left;
        }


    }

    public static void test() {
        BinaryTreeNode root1 = BinaryTreeUtil.reconstructBinaryTree(
            Arrays.asList(10, 6, 4, 8, 14, 12, 16), 
            Arrays.asList(4, 6, 8, 10, 12, 14, 16)
        );
        root1 = convert(root1);
        print(root1);

        BinaryTreeNode root2 = BinaryTreeUtil.reconstructBinaryTree(
            Arrays.asList(10, 5, 4, 3), 
            Arrays.asList(3, 4, 5, 10)
        );
        root2 = convert(root2);
        print(root2);

        BinaryTreeNode root3 = BinaryTreeUtil.reconstructBinaryTree(
            Arrays.asList(3, 4, 5, 10), 
            Arrays.asList(3, 4, 5, 10)
        );
        root3 = convert(root3);
        print(root3);
    }

    public static void main(String[] args) {
        test();
    }
}