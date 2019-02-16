public class InversePairs {
    public static int countInversePairs(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("invalid parameter");

        return mergeSort(arr, 0, arr.length);
    }

    public static int mergeSort(int[] array, int start, int end) {

        if (end - start == 1)
            return 0;

        int leftEnd = (end + start) / 2;
        int leftCount = mergeSort(array, start, leftEnd);
        int rigthCount = mergeSort(array, leftEnd, end);

        int[] copyArr = new int[end - start];

        int p1 = leftEnd - 1;
        int p2 = end - 1;
        int p = copyArr.length - 1;
        int count = 0;

        while (p1 >= start && p2 >= leftEnd) {
            if (array[p1] > array[p2]) {
                count += p2 - leftEnd + 1;
                copyArr[p] = array[p1];
                p1--;
            } else {
                copyArr[p] = array[p2];
                p2--;
            }
            p--;
        }

        while (p1 >= start) {
            copyArr[p] = array[p1];
            p1--;
        }

        while (p2 >= leftEnd) {
            copyArr[p] = array[p2];
            p2--;
        }

        for (int i = 0; i < copyArr.length; i++) {
            array[start + i] = copyArr[i];
        }

        return count + leftCount + rigthCount;

    }

    public static void test() {
        System.out.println(countInversePairs(
            new int[] {7, 5, 6, 4}
        ));

        System.out.println(countInversePairs(
            new int[] {7, 6, 5, 4}
        ));

        System.out.println(countInversePairs(
            new int[] {4, 5, 6, 7}
        ));

        System.out.println(countInversePairs(
            new int[] {7, 7, 6, 6}
        ));
    }

    public static void main(String[] args) {
        test();
    }
}