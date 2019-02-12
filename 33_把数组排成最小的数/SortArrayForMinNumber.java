import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortArrayForMinNumber {
    public static String minNumber(int[] arr) {
        int len = arr.length;
        String[] stringArr = new String[len];

        for (int i = 0; i < len; i++) {
            stringArr[i] = String.valueOf(arr[i]);
        }

        List<String> ret = Arrays.asList(stringArr);
        Collections.sort(ret, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    o2 += o1;
                else if (o1.length() < o2.length())
                    o1 += o2;
                
                int minLength = o1.length() > o2.length() ? o2.length() : o1.length();

                for (int i = 0; i < minLength; i++) {
                    char c1 = o1.charAt(i);
                    char c2 = o2.charAt(i);
                    if (c1 < c2) 
                        return -1;
                    else if (c1 > c2)
                        return 1;
                }
                return 0;
            }
        });
        StringBuilder builder = new StringBuilder(ret.size());
        for (String s : ret) {
            builder.append(s);
        }

        return builder.toString();
    }

    public static void test() {
        System.out.println(minNumber(new int[] {
            3, 32, 321
        }));
    }

    public static void main(String[] args) {
        test();
    }
}