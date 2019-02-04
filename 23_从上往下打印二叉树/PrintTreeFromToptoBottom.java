import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTreeFromToptoBottom {
    public static void print(BinaryTreeNode root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            
            System.out.println(node.value);

            if (node.left != null) 
                queue.offer(node.left);
            
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public static void test() {
        List<Integer> preOrder = Arrays.asList(8, 6, 5, 10, 11);
        List<Integer> midOrder = Arrays.asList(5, 6, 8, 10, 11);
        BinaryTreeNode root = BinaryTreeUtil.reconstructBinaryTree(preOrder, midOrder);

        print(root);
    }

    public static void main(String[] args) {
        test();
    }
}