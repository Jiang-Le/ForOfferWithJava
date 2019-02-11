public class MoreThanHalfNumber {
    // 假定一定存在出现次数超过一半的数

    public static int solution1(int[] arr) {
        int len = arr.length;
        int index = 0;
        int start = 0;
        int end = len;
        while (index != len / 2) {
            index = partition(arr, start, end);

            if (index > len / 2)
                end = index;
            else if (index < len / 2) 
                start = index + 1;
        }

        return arr[index];
    }

    private static int partition(int[] arr, int start, int end) {
        int index = start;

        for (int i = start + 1; i < end; i++) {
            if (arr[i] > arr[start])
                continue;
            else {
                index++;
                swap(arr, index, i);
            }
        }
        swap(arr, index, start);
        return index;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static int solution2(int[] arr) {
        // 这种解法假设一定存在出现次数超过半数的数，否则结果不对
        // 比如数组{1, 3, 1, 3, 2}

        int current = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                current = arr[i];
                count = 1;
            } else if (arr[i] == current)
                count++;
            else {
                count--;
            }
        }
        return current;
    }

    public static void test() {
        System.out.println(solution1(new int[] {1}));
        System.out.println(solution1(new int[] {1, 1}));
        System.out.println(solution1(new int[] {1, 3, 5, 3, 3, 4, 3}));
        System.out.println(solution1(new int[] {1, 3, 3, 3, 4, 3}));

        System.out.println(solution2(new int[] {1}));
        System.out.println(solution2(new int[] {1, 1}));
        System.out.println(solution2(new int[] {1, 3, 5, 3, 3, 4, 3}));
        System.out.println(solution2(new int[] {1, 3, 3, 3, 4, 3}));
    }

    public static void main(String[] args) {
        test();
    }

}