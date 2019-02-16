public class ContinueSequenceWithSum {
    public static void findContinueSequence(int target) {
        if (target <= 2)
            return;

        int low = 1;
        int high = 2;
        int sum = low + high;

        while (high < target) {
            if (sum < target) {
                high++;
                sum += high;
            } else if (sum > target) {
                sum -= low;
                low++;
            } else {
                printSequence(low, high);
                sum -= low;
                low++;
                high++;
                sum += high;
            }
        }
    }

    private static void printSequence(int low, int high) {
        for (int i = low; i <= high; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void test() {
        findContinueSequence(15);
        findContinueSequence(100);
        findContinueSequence(4);
        findContinueSequence(3);
    }

    public static void main(String[] args) {
        test();
    }
}