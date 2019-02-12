import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KLeastNumbers {
    public static int[] solution1(int[] arr, int k) {
        int len = arr.length;
        if (len <= k)
            return arr;

        if (k <= 0)
            return null;

        int index = 0;
        int start = 0;
        int end = len;
        while (index != k) {
            index = partition(arr, start, end);
            if (index < k) 
                start = index + 1;
            else if (index > k)
                end = index;
        }
        
        return Arrays.copyOf(arr, index);
        
    }

    private static int partition(int[] arr, int start, int end) {
        int index = start;

        for (int i = start + 1; i < end; i++) {
            if (arr[i] < arr[start]) {
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

    public static int[] solution2(int[] arr, int k) {
        int len = arr.length;

        if (k <= 0)
            return null;
        if (len <= k)
            return arr;

        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < len; i++) {
            if (heap.size() < k)
                heap.offer(arr[i]);
            else {
                if (heap.peek() > arr[i]) {
                    heap.poll();
                    heap.offer(arr[i]);
                }
            }
        }

        return heap.stream().mapToInt(i->i).toArray();
    }

    public static void test() {
        int[] ret1 = solution1(new int[]{5, 4, 3, 2, 1}, 3);
        System.out.println(Arrays.toString(ret1));

        int[] ret2 = solution1(new int[]{5, 4, 3, 2, 1}, 6);
        System.out.println(Arrays.toString(ret2));

        int[] ret3 = solution1(new int[]{3, 3, 2, 2, 1, 1}, 3);
        System.out.println(Arrays.toString(ret3));

        int[] ret4 = solution2(new int[]{5, 4, 3, 2, 1}, 3);
        System.out.println(Arrays.toString(ret4));

        int[] ret5 = solution2(new int[]{5, 4, 3, 2, 1}, 6);
        System.out.println(Arrays.toString(ret5));

        int[] ret6 = solution2(new int[]{3, 3, 2, 2, 1, 1}, 3);
        System.out.println(Arrays.toString(ret6));
    }

    public static void main(String[] args) {
        test();
    }
}