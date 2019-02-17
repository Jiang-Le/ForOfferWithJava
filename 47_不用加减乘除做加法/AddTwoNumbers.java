public class AddTwoNumbers {
    public static int add(int n1, int n2) {
        if (n2 == 0)
            return n1;
        int n = n1 ^ n2;
        int carry = (n1 & n2) << 1;
        return add(n, carry);
    }

    public static void test() {
        System.out.println(add(5, 3));
        System.out.println(add(5, 0));
        System.out.println(add(0, 3));
        System.out.println(add(5, -3));
        System.out.println(add(-5, -3));
    }

    public static void main(String[] args) {
        test();
    }
}