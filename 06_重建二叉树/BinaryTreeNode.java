import java.util.List;
import java.util.ArrayList;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        value = val;
    }

    public void display() {
        List<BinaryTreeNode> nodes = new ArrayList<>();
        nodes.add(this);

        while(!nodes.isEmpty()) {
            List<BinaryTreeNode> temp = new ArrayList<>();
            for(BinaryTreeNode node : nodes) {
                if (node == null)
                    System.out.print("null ");
                else {
                    System.out.print(String.format("%d ", node.value));
                    temp.add(node.left);
                    temp.add(node.right);
                }
            }
            System.out.println();
            nodes = temp;
        }
    }
}