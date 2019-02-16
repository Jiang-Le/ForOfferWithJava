public class LeftRotateString {
    public static void rotate(char[] charArr, int n) {
        if (n < 0)
            throw new RuntimeException("invalid parameter");

        n = n % charArr.length;

        if (n == 0)
            return;
        
        reverse(charArr, 0, charArr.length - 1);
        reverse(charArr, 0, charArr.length - n - 1);
        reverse(charArr, charArr.length - n, charArr.length - 1);
    }

    private static void reverse(char[] charArr, int start, int end) {
        char temp;

        for (int i = start, j = end; i < j; i++, j--) {
            temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
        }
    }

    public static void test() {
        char[] charArr = "hello world".toCharArray();
        rotate(charArr, 0);
        System.out.println(new String(charArr));
        rotate(charArr, 1);
        System.out.println(new String(charArr));
        rotate(charArr, charArr.length - 1);
        System.out.println(new String(charArr));
        rotate(charArr, charArr.length);
        System.out.println(new String(charArr));
        rotate(charArr, charArr.length + 1);
        System.out.println(new String(charArr));
    }

    public static void main(String[] args) {
        test();
    }
}