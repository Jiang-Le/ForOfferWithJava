public class TwoNumbersWithSum {
    public static int[] findNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length < 2)
            throw new RuntimeException("invalid parameter");
        
        int p1 = 0;
        int p2 = array.length - 1;

        int[] ret = null;

        while (p1 < p2) {
            if (array[p1] + array[p2] < sum)
                p1++;
            else if (array[p1] + array[p2] > sum)
                p2--;
            else {
                ret = new int[2];
                ret[0] = array[p1];
                ret[1] = array[p2];
                break;
            }
        }

        return ret;
    }

    public static void test() {
        int[] ret = findNumbersWithSum(
            new int[]{1, 2, 4, 7, 11, 15}, 15);
        printArray(ret);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}