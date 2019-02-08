import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class PathInTree {
    public static void findPath(BinaryTreeNode root, int target) {
        recursion(root, target, new ArrayList<>());
    }

    private static void recursion(BinaryTreeNode root, int target, List<Integer> path) {
        if (root == null)
            return;

        path.add(root.value);

        if (target == root.value)
            // 考虑到之后的节点中的值可能存在负数，所以不直接返回
            printPath(path);

        recursion(root.left, target - root.value, path);
        recursion(root.right, target - root.value, path);

        path.remove(path.size() - 1);

    }

    private static void printPath(List<Integer> path) {
        for (int v : path) {
            System.out.print(String.format(
                "%d ",
                v
            ));
        }
        System.out.println();
    }

    public static void test() {
        List<Integer> preOrder = Arrays.asList(10, 5, 4, 7, 12);
        List<Integer> midOrder = Arrays.asList(4, 5, 7, 10, 12);
        BinaryTreeNode root = BinaryTreeUtil.reconstructBinaryTree(preOrder, midOrder);
        findPath(root, 15);
    }

    public static void main(String[] args) {
        test();
    }
}