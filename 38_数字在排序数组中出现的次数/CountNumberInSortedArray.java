public class CountNumberInSortedArray {
    public static int count(int[] array, int target) {
        if (array == null)
            throw new RuntimeException("invalid parameter");
        
        if (array.length == 0)
            return 0;

        int low = 0;
        int high = array.length - 1;

        int mid = (low + high) / 2;
        while (low < high) {
            if (array[mid] > target) 
                high = mid - 1;
            else if (array[mid] < target)
                low = mid + 1;
            else
                break;
            mid = (low + high) / 2;
        }

        if (array[mid] != target) 
            return 0;

        int leftBound = findLeftBound(array, 0, mid, target);
        int rightBound = findRightBound(array, mid, array.length - 1, target);

        return rightBound - leftBound + 1;
    }

    private static int findLeftBound(int[] array, int start, int end, int target) {
        int mid = (start + end) / 2;
        while (start < end) {
            if (array[mid] < target) 
                start = mid + 1;
            else {
                // array[mid] == target
                end = mid;
            }
            mid = (start + end) / 2;
        }
        return mid;
    }

    private static int findRightBound(int[] array, int start, int end, int target) {
        int mid = (start + end + 1) / 2;
        while (start < end) {
            if (array[mid] > target) 
                end = mid - 1;
            else {
                // array[mid] == target
                start = mid;
            }
            mid = (start + end + 1) / 2;
        }
        return mid;
    }

    public static void test() {
        System.out.println(
            count(new int[] {1, 2, 3, 3, 3, 3, 4, 5}, 3)
        );

        System.out.println(
            count(new int[] {3}, 3)
        );

        System.out.println(
            count(new int[] {3, 3, 3, 3}, 3)
        );

        System.out.println(
            count(new int[] {1, 2, 3, 3, 3, 3, 4, 5}, 7)
        );

        System.out.println(
            count(new int[] {1, 2, 3, 3, 3, 3, 4, 5}, 5)
        );

        System.out.println(
            count(new int[] {1, 2, 3, 3, 3, 3, 4, 5}, 1)
        );
    }

    public static void main(String[] args) {
        test();
    }
}