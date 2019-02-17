import java.util.Arrays;

public class ContinousCards {
    public static boolean isContinous(int[] numbers) {
        Arrays.sort(numbers);
        int zeroCount = 0;
        int i = 0;
        while (numbers[i] == 0) {
            i++;
            zeroCount++;
        }
        int last = numbers[i++];
        for (; i < numbers.length; i++) {
            int diff = numbers[i] - last;
            if (diff == 0)
                return false;
            else if (diff > 1) {
                zeroCount -= diff - 1;
                if (zeroCount < 0)
                    return false;
            }
            last = numbers[i];
        }
        return true;
    }

    public static void test() {
        System.out.println(isContinous(
            new int[] {1, 2, 3, 4, 5}
        ));

        System.out.println(isContinous(
            new int[] {1, 2, 3, 4, 6}
        ));

        System.out.println(isContinous(
            new int[] {0, 0, 3, 5, 4}
        ));

        System.out.println(isContinous(
            new int[] {1, 2, 0, 0, 5}
        ));

        System.out.println(isContinous(
            new int[] {1, 0, 5, 4, 3}
        ));

        System.out.println(isContinous(
            new int[] {1, 0, 3, 0, 3}
        ));
    }

    public static void main(String[] args) {
        test();
    }
}