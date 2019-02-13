import java.util.HashMap;
import java.util.Map;

public class FirstChar {
    public static char findFirstChar(char[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("invalid parameter");

        Map<Character, Integer> map = new HashMap<>();

        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : arr) {
            if (map.get(c) == 1)
                return c;
        }

        throw new RuntimeException("cannot find a not repeating char");
    }

    public static void test() {
        System.out.println(findFirstChar(
            "abaccdeff".toCharArray()
        ));
    }

    public static void main(String[] args) {
        test();
    }
}