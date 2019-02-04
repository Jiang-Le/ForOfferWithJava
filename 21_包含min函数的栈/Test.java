public class Test {
    public static void test() {
        SpecialStack<Integer> stack = new SpecialStack<>();
        stack.push(5);
        System.out.println(stack.min());
        stack.push(6);
        System.out.println(stack.min());
        stack.push(8);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }

    public static void main(String[] args) {
        test();
    }
}