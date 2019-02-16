import java.util.List;

public class BinaryTreeUtil {
    public static BinaryTreeNode reconstructBinaryTree(List<Integer> preOrder, List<Integer> midOrder) {
        if (preOrder.size() != midOrder.size()) 
            throw new IllegalArgumentException("invalid input");
        
        if (preOrder.size() == 0) 
            return null;
        
        return recursiveReconstruct(preOrder, midOrder);
    }

    private static BinaryTreeNode recursiveReconstruct(List<Integer> preOrder, List<Integer> midOrder) {
        int index = midOrder.indexOf(preOrder.get(0));
        BinaryTreeNode root = new BinaryTreeNode(preOrder.get(0));

        if (index == -1)
            throw new IllegalArgumentException("invalid input");

        if (preOrder.size() > 1) {
            if (index > 0) {
                List<Integer> leftTreePreOrder = preOrder.subList(1, index + 1);
                List<Integer> leftTreeMidOrder = midOrder.subList(0, index);
                root.left = recursiveReconstruct(leftTreePreOrder, leftTreeMidOrder);
            }
            if (index < midOrder.size() - 1) {
                List<Integer> rightTreePreOrder = preOrder.subList(index + 1, preOrder.size());
                List<Integer> rigthTreeMidOrder = midOrder.subList(index + 1, midOrder.size());
                root.right = recursiveReconstruct(rightTreePreOrder, rigthTreeMidOrder);
            }
        }

        return root;
    }
}