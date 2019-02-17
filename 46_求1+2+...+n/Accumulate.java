public class Accumulate {
    public static int solution(int n) {
        int[] sum = new int[1];

        recurse(n, sum);
        return sum[0];
    }

    private static boolean recurse(int n, int[]sum) {
        sum[0] += n;
        return n == 0 || recurse(n - 1, sum);
    }

    public static void test() {
        System.out.println(solution(5));
    }

    public static void main(String[] args) {
        test();
    }
}