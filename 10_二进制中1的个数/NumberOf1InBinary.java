public class NumberOf1InBinary {
    public static int count(int num) {
        int count = 0;

        while (num != 0) {
            count++;
            num = (num - 1) & num;
        }

        return count;
    }
}