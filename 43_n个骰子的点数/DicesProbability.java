import java.util.Arrays;

public class DicesProbability {
    public static void getProbability(int n) {
        int[] count1 = new int[6 * n + 1];
        int[] count2 = new int[6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            count1[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (k >= j)
                        break;
                    count2[j] += count1[j - k];
                }
            }
            count1 = Arrays.copyOf(count2, count2.length);
            count2 = new int[6 * n + 1];
        }

        for (int i = n; i <= n * 6; i++) {
            System.out.println(
                String.format("%d:%d:%f", i, count1[i], count1[i] / Math.pow(6, n))
            );
        }
    }

    public static void test() {
        getProbability(6);
    }

    public static void main(String[] args) {
        test();
    }
}