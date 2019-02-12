public class GreatestSumOfSubarrays {
    public static int findGreatestSumOfSubArray(int[] arr) {
        
        if (arr == null || arr.length == 0)
            throw new RuntimeException("invalid paramater");

        int len = arr.length;
        
        
        int[] dp = new int[len];
        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = arr[i];
            } else {
                dp[i] = dp[i - 1] + arr[i];
            }

            max = dp[i] > max ? dp[i] : max;
        }

        return max;
    }

    public static void test() {
        System.out.println(findGreatestSumOfSubArray(new int[]{
            1, -2, 3, 10, -4, 7, 2, -5
        }));

        System.out.println(findGreatestSumOfSubArray(new int[]{
            -3, -5, -1, -2, -4
        }));

        System.out.println(findGreatestSumOfSubArray(new int[]{
            1, 2, 3, 4, 5
        }));

        System.out.println(findGreatestSumOfSubArray(new int[]{ }));
    }

    public static void main(String[] args) {
        test();
    }
}