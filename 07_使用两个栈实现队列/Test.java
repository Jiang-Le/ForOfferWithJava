import java.util.Arrays;

public class Test {
    public static void test() {
        Queue<Integer> q = new Queue<>();
        
        for (int i : Arrays.asList(1, 2, 3, 4, 5)) {
            q.appendTail(i);
        }
        
        for (int i : Arrays.asList(1, 2, 3, 4, 5)) {
            q.appendTail(i);
            System.out.println(q.deleteHead());
        }

        while (q.size() != 0)
            System.out.println(q.deleteHead());
    }

    public static void main(String[] args) {
        test();
    }
}