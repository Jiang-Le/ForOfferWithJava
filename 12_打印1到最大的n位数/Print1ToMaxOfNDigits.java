public class Print1ToMaxOfNDigits {
    public static void print(int n) {
        char[] digits = new char[n + 1];
        for (int i = 0; i <= n; i++) {
            digits[i] = '0';
            if (i == n)
                digits[i] = '1';
        }

        while (digits[0] != '1') {
            printNumber(digits);
            increment(digits);
        }
    }

    private static void printNumber(char[] digits) {
        int n = 0;
        while (digits[n] == '0') {
            n++;
        }
        for (int i = n; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }

    private static void increment(char[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] > '9') {
                digits[i] -= 10;
                carry = 1;
            } else {
                carry = 0;
                break;
            }
        }
        if (carry > 1)
            throw new RuntimeException("the size of digits is not enough");
    }

    public static void test() {
        print(4);
    }

    public static void main(String[] args) {
        test();
    }
}