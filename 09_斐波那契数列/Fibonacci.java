public class Fibonacci {
    public int fibonacci(int n) {
        if (n < 0)
            throw new RuntimeException("invalid input");
        int a = 0, b = 1;
        if (n == 0)
            return a;
        n--;

        int temp;
        while (n > 0) {
            temp = b;
            b = a + b;
            a = temp;
            n--;
        }
        return b;
    }
}