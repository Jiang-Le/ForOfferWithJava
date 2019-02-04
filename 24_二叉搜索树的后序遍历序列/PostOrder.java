import java.util.Arrays;
import java.util.List;

public class PostOrder {
    public static boolean isPostOrderOfSearchTree(
        List<Integer> order
    ) {
        if (order.size() == 1 || order.size() == 0)
            return true;

        int rootVal = order.get(order.size() - 1);

        int index = 0;
        // find the first value which is bigger than rootVal
        while(index < order.size() - 1 && order.get(index) < rootVal) index++;


        for (int i = index; i < order.size() - 1; i++) {
            if (order.get(i) < rootVal)
                return false;
        }

        return isPostOrderOfSearchTree(order.subList(0, index)) 
            && isPostOrderOfSearchTree(order.subList(index, order.size() - 1));
    }

    public static void test() {
        System.out.println(isPostOrderOfSearchTree(Arrays.asList(
            5, 7, 6, 9, 11, 10, 8
        )));
        System.out.println(isPostOrderOfSearchTree(Arrays.asList(
            7, 4, 6, 5
        )));

    }

    public static void main(String[] args) {
        test();
    }
}