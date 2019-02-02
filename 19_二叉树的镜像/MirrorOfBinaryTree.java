import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MirrorOfBinaryTree {
    public static void getMirror(BinaryTreeNode root) {
        if (root == null)
            return;
        BinaryTreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if (root.left != null)
            getMirror(root.left);   
        if (root.right != null)
            getMirror(root.right);
    }

    public static void test() {
        List<Integer> preOrder = Arrays.asList(8, 7, 6, 5, 4);
        List<Integer> midOrder = Arrays.asList(4, 5, 6, 7, 8);
        BinaryTreeNode root1 = BinaryTreeUtil.reconstructBinaryTree(preOrder, midOrder);

        root1.display();
        getMirror(root1);
        root1.display();
    }

    public static void main(String[] args) {
        test();
    }
}