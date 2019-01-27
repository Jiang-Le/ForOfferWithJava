import java.util.Arrays;

public class ReplaceBlank {
    public static void replace(char[] string, int relStringLength) {
        // 假设给定的长度恰好为转换后字符串的长度
        int arrLength = string.length;

        for (int i = relStringLength - 1, j = arrLength - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                string[j--] = '0';
                string[j--] = '2';
                string[j--] = '%';
            } else {
                string[j--] = string[i];
            }
        }
    }

    private static boolean isEqual(char[] string1, char[] string2) {
        if (string1.length != string2.length)
            return false;
        
        int len = string1.length;
        for (int i = 0; i < len; i++) {
            if (string1[i] != string2[i])
                return false;
        }
        return true;
    }

    public static void test() {
        char[] string = {'h', 'e', 'l', 'l', 'o'};
        replace(string, 5);
        assert isEqual(string, new char[] {'h', 'e', 'l', 'l', 'o'}) == true;

        char[] string1 = new char[13];
        System.arraycopy("hello world".toCharArray(), 0, string1, 0, 11);
        replace(string1, 11);
        assert isEqual(string1, new char[] {'h', 'e', 'l', 'l', 'o', '%', '2', '0', 'w', 'o', 'r', 'l', 'd'}) == true;

        System.out.println("success");
    }

    public static void main(String[] args) {
        test();
    }
}