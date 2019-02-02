import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SubstructureInTree {
    public static boolean isSubstructure(BinaryTreeNode root1, 
                                        BinaryTreeNode root2) {
        boolean result = isHaveTheTree2(root1, root2);
        if (!result && root1 != null) 
            result = isSubstructure(root1.left, root2);

        if (!result && root1 != null) 
            result = isSubstructure(root1.right, root2);

        return result;
    }

    public static boolean isHaveTheTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null || root1.value != root2.value) {
            return false;
        }

        return isHaveTheTree2(root1.left, root2.left) && isHaveTheTree2(root1.right, root2.right);
    }

    public static void test() {
        List<Integer> preOrder = Arrays.asList(8, 1, 9, 2, 4, 7, 6);
        List<Integer> midOrder = Arrays.asList(9, 1, 4, 2, 7, 8, 6);
        BinaryTreeNode root1 = BinaryTreeUtil.reconstructBinaryTree(preOrder, midOrder);
        List<Integer> preOrder1 = Arrays.asList(1, 9, 7);
        List<Integer> midOrder1 = Arrays.asList(9, 1, 7);
        BinaryTreeNode root2 = BinaryTreeUtil.reconstructBinaryTree(preOrder1, midOrder1);
        System.out.println(isSubstructure(root1, root2));
        
        System.out.println(isSubstructure(root1, null));

        System.out.println(isSubstructure(null, root2));
    }

    public static void main(String...args) {
        test();
    }
}