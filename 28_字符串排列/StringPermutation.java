import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutation {
    public static List<String> permutation(String string) {
        if (string == null || string.length() == 0)
            return Arrays.asList();

        if (string.length() == 1)
            return Arrays.asList(string);

        Set<Character> viewed = new HashSet<>();
        List<String> ret = new ArrayList<>();

        int len = string.length();

        for (int i = 0; i < len; i++) {
            char c = string.charAt(i);
            if (viewed.contains(c))
                continue;
            viewed.add(c);
            
            List<String> subResult = permutation(string.substring(0, i) + string.substring(i + 1, len));
            for (String s : subResult) {
                ret.add(s + c);
            }
        }

        return ret;
    }

    public static List<String> combination(String string) {
        // 未考虑字符重复的情况

        if (string == null || string.length() == 0)
            return Arrays.asList();

        if (string.length() == 1)
            return Arrays.asList(string);
        
        List<String> ret = new ArrayList<>();

        List<String> subResult = combination(string.substring(1));
        ret.addAll(subResult);

        char c = string.charAt(0);
        for (String s : subResult) {
            ret.add(s + c);
        }
        ret.add(String.valueOf(c));

        return ret;
    }

    public static void test() {
        for (String s : permutation("abcdd")) {
            System.out.println(s);
        }

        for (String s : combination("abcc")) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        test();
    }
}