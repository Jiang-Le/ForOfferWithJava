public class Power {
    public static double power(double base, int exponent) {
        if (equal(base, 0.0) && exponent <= 0)
            throw new RuntimeException("invalid input");
        
        if (exponent == 0)
            return 1;

        boolean isNegtaive = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegtaive = true;
        }

        double part1 = 1.0;
        double part2 = base;
        while (exponent > 1) {
            if ((exponent & 0x1) == 1) {
                part1 *= part2;
            }
            part2 *= part2;
            exponent >>>= 2;
        }
        return isNegtaive ? 1 / (part1 * part2) : part1 * part2;
    }

    private static boolean equal(double num1, double num2) {
        if (Math.abs(num1 - num2) < 0.0000001)
            return true;
        return false;
    }

    public static void test() {
        System.out.println(power(2.0, 5));
        System.out.println(power(2.0, 6));
        System.out.println(power(2.0, 4));
        System.out.println(power(2.0, -4));
        System.out.println(power(2.0, -5));
        System.out.println(power(2.0, 1));
        System.out.println(power(2.0, 0));
        System.out.println(power(-2.0, 3));
    }

    public static void main(String[] args) {
        test();
    }
}