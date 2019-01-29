public class ReorderArray {
    public static void reorder(int[] array) {
        int evenStartIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 0x1) == 1) {
                int tem = array[evenStartIndex];
                array[evenStartIndex] = array[i];
                array[i] = tem;
                evenStartIndex++;
            }
        }
    }

    private static void printArray(int[] array) {
        System.out.print('[');
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) 
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void test() {
        int[] arr1 = new int[] {1, 2, 3, 4, 5, 6};
        reorder(arr1);
        printArray(arr1);

        int[] arr2 = new int[] {1, 3, 5, 2, 4, 6};
        reorder(arr2);
        printArray(arr2);

        int[] arr3 = new int[] {2, 4, 6, 1, 3, 5};
        reorder(arr3);
        printArray(arr3);
        
        int[] arr4 = new int[] {1};
        reorder(arr4);
        printArray(arr4);
        
        int[] arr5 = new int[] {2};
        reorder(arr5);
        printArray(arr5);
        
        int[] arr6 = new int[] {};
        reorder(arr6);
        printArray(arr6);
    }

    public static void main(String[] args) {
        test();
    }
}