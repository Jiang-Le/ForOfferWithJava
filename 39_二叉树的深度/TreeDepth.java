import java.util.Arrays;

public class TreeDepth {
    public static int getDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void test() {
        BinaryTreeNode root = BinaryTreeUtil.reconstructBinaryTree(
            Arrays.asList(1, 2, 4, 5, 7, 3, 6), 
            Arrays.asList(4, 2, 7, 5, 1, 3, 6));
        System.out.println(getDepth(root));
    }

    public static void main(String[] args) {
        test();
    }
}