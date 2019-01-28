import java.util.Arrays;

public class MinNumberInRotatedArray {
    public static int findMinNumber(int[] array) {
        if (array.length == 0)
            throw new RuntimeException("invalid input");

        int low = 0;
        int high = array.length - 1;
        int mid = -1;
        while (low < high - 1) {
            // ordered
            if (array[low] < array[high])
                return array[low];
            
            mid = (low + high) / 2;

            if (array[mid] == array[low] && array[mid] == array[high])
                return findInOrder(array, low, high);

            if (array[mid] >= array[low])
                low = mid + 1;
            else if (array[mid] <= array[high])
                high = mid;
        }
        return array[low] < array[high] ? array[low] : array[high];
    }

    private static int findInOrder(int[] array, int start, int end) {
        int min = array[start];
        for (int i = start; i <= end; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    public static void test() {
        assert findMinNumber(new int[]{3, 4, 5, 1, 2}) == 1;

        assert findMinNumber(new int[]{1, 2, 3, 4, 5}) == 1;

        assert findMinNumber(new int[]{5, 6, 7, 1, 2, 3, 4}) == 1;

        assert findMinNumber(new int[]{5, 6, 7, 2, 2, 2, 2}) == 2;

    }

    public static void main(String[] args) {
        test();
    }
}