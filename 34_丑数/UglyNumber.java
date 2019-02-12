import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class UglyNumber {
    public static int[] getUglyNumber(int index) {
        if (index < 1)
            throw new RuntimeException("invalid parameter");
        
        if (index == 1)
            return new int[]{1};

        int[] ret = new int[index];
        ret[0] = 1;
        int indexForTwo = 0;
        int indexForThree = 0;
        int indexForFive = 0;

        for (int i = 1; i < index; i++) {
            ret[i] = Collections.min(Arrays.asList(
                ret[indexForTwo] * 2,
                ret[indexForThree] * 3,
                ret[indexForFive] * 5
            ));

            if (ret[i] == ret[indexForTwo] * 2)
                indexForTwo++;
            if (ret[i] == ret[indexForThree] * 3)
                indexForThree++;
            if (ret[i] == ret[indexForFive] * 5)
                indexForFive++;
        }

        return ret;
    }

    public static void test() {
        System.out.println(
            Arrays.stream(getUglyNumber(20))
            .boxed()
            .collect(Collectors.toList())
        );

    }

    public static void main(String[] args) {
        test();
    }
}